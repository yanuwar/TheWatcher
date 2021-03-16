package com.waigres.services

import android.app.ActivityManager
import android.app.Service
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log.e
import android.widget.Toast
import java.util.*


class TheWatcher: Service() {
    private fun getForegroundTask(): String? {
        var currentApp = "NULL"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
        e("test", "Current App in foreground currentApp is: $currentApp")
        return currentApp
    }

    private fun runningTheWatcher () {
        val dateNow = Calendar.getInstance()
        val dateMin = Calendar.getInstance()
        dateMin.set(dateMin.get(Calendar.YEAR), dateMin.get(Calendar.MONTH), dateMin.get(Calendar.DATE), 21, 10, 0)
        val dateMax = Calendar.getInstance()
        dateMax.set(dateMin.get(Calendar.YEAR), dateMin.get(Calendar.MONTH), dateMin.get(Calendar.DATE), 22, 30, 0)

        e("test", "${dateMin.timeInMillis} - ${dateNow.timeInMillis} - ${dateMax.timeInMillis}")
        if (dateNow.timeInMillis >= dateMin.timeInMillis && dateNow.timeInMillis <= dateMax.timeInMillis) {
            val foregroundTask = getForegroundTask()
            e("test", "Current App in foreground foregroundTask is: $foregroundTask")

            if (foregroundTask.equals("com.instagram.android")) {
                e("Test", "warning")
            }
        } else {
            e("Test", "running warning")
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented");
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        runningTheWatcher()
        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
    }
}