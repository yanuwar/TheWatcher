package com.waigres

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.AppOpsManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Process
import android.provider.Settings
import android.util.Log.e
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceManager
import com.waigres.helper.ParseFromWeb
import com.waigres.receiver.MyBroadCastReceiver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    companion object {
        val LIST_FUN_FACT = "list_fun_fact"
    }
    val REQ_CODE_ACTION_USAGE_ACCESS_SETTINGS = 1009
    val REQ_CODE_ACTION_MANAGE_OVERLAY_PERMISSION = 1008

    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = PreferenceManager.getDefaultSharedPreferences(application)
        requestUsageStatsPermission()

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(this, MyBroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        }

        close_btn.setOnClickListener {
            finish()
        }

        getHtmlFromWeb()
    }
    fun requestUsageStatsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1
                && !hasUsageStatsPermission(this)) {
            val intent = Intent(
                Settings.ACTION_USAGE_ACCESS_SETTINGS,
                Uri.parse("package:" + this.packageName)
            )
            startActivityForResult(intent, REQ_CODE_ACTION_USAGE_ACCESS_SETTINGS)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + this.packageName)
                )
                startActivityForResult(intent, REQ_CODE_ACTION_MANAGE_OVERLAY_PERMISSION)
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    fun hasUsageStatsPermission(context: Context): Boolean {
        val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = appOps.checkOpNoThrow("android:get_usage_stats",
                Process.myUid(), context.getPackageName())
        return mode == AppOpsManager.MODE_ALLOWED
    }

    private fun getHtmlFromWeb() {
        val url: URL? = try {
            URL("https://kids.niehs.nih.gov/games/riddles/jokes/fun-facts-and-trivia/index.htm")
        } catch (e: MalformedURLException) {
            null
        }
        val result = lifecycleScope.async(Dispatchers.IO) {
            try {
                url?.readText()
            } catch (e: IOException) {
                "Error....\n\n$e"
            }
        }
        lifecycleScope.launch(Dispatchers.Main) {
            val html = result.await()?:""
            val listFunFact = ParseFromWeb(html).getListFunFact()
            saveListFunFact(listFunFact)
        }
    }
    private fun saveListFunFact (list: List<String>) {
        prefs?.let {
            val editor: Editor = it.edit()
            editor.putString(LIST_FUN_FACT, list.toString())
            editor.commit()
        }
    }
    private fun getFunFact (): List<String> {
        val listString = prefs?.getString(LIST_FUN_FACT, "")

        return listString?.replace("[", "")?.replace("]", "")?.split("\\s*,\\s*")?: arrayListOf()
    }
}