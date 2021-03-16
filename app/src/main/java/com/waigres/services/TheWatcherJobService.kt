package com.waigres.services

import android.app.ActivityManager
import android.app.PendingIntent
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.util.Log.e
import androidx.core.app.JobIntentService
import com.waigres.MainActivity
import com.waigres.receiver.TheWatcherReceiver
import java.util.*

class TheWatcherJobService: JobIntentService() {
    private fun getForegroundTask(): String? {
        var currentApp = ""
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            val usm = this.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val time = System.currentTimeMillis()
            val appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 1000, time)
            if (appList != null && appList.size > 0) {
                val mySortedMap: SortedMap<Long, UsageStats> = TreeMap()
                for (usageStats in appList) {
                    mySortedMap[usageStats.lastTimeUsed] = usageStats
                }
                if (mySortedMap != null && !mySortedMap.isEmpty()) {
                    currentApp = mySortedMap[mySortedMap.lastKey()]!!.packageName
                }
            }
        } else {
            val am = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val tasks = am.runningAppProcesses
            currentApp = tasks[0].processName
        }
        e("Test", currentApp)
        return currentApp
    }

    private fun runningTheWatcher (intent: Intent) {
        val foregroundTask = getForegroundTask()
        val intentWatcher = Intent(this, TheWatcherReceiver::class.java)
        intentWatcher.putExtra("foregroundTask", foregroundTask)
        sendBroadcast(intentWatcher)
    }
    override fun onHandleWork(intent: Intent) {
        runningTheWatcher(intent)
    }
    companion object {
        val JOB_ID = 1001

        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, TheWatcherJobService::class.java, JOB_ID, work)
        }
    }
}