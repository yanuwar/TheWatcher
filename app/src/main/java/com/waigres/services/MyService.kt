package com.waigres.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log.e
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService
import com.waigres.receiver.MyBroadCastReceiver

class MyService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val alarmIntent = Intent(this, MyBroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent)
        }
    }
    companion object {
        val JOB_ID = 1000

        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, MyService::class.java, JOB_ID, work)
        }
    }
}
