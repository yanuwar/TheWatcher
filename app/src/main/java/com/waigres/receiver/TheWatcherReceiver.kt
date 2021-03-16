package com.waigres.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log.e
import com.waigres.MainActivity
import com.waigres.WarningActivity
import com.waigres.helper.DateChecker
import com.waigres.helper.ForegroundsTaskChecker
import com.waigres.model.Date


class TheWatcherReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val foregroundTask = intent.getStringExtra("foregroundTask")?:""

        if (foregroundTask.isNotEmpty()) {
            if (DateChecker(Date(8, 0, 0), Date(17, 0, 0)).isIncludedDate()) {
                val list = arrayListOf<String>()
                list.add("com.instagram.android")
                list.add("com.whatsapp")

                if (ForegroundsTaskChecker(list).isRestricted(foregroundTask)) {
                    val activity = Intent(context, WarningActivity::class.java)
                    activity.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(activity)
                }
            }
        }
    }
}