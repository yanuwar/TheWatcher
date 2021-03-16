package com.waigres.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log.e
import android.widget.Toast
import com.waigres.WarningActivity
import com.waigres.helper.DateChecker
import com.waigres.helper.ForegroundsTaskChecker
import com.waigres.model.Date
import com.waigres.services.MyService
import com.waigres.services.TheWatcherJobService

class MyBroadCastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            val intentService = Intent(context, MyService::class.java)
            MyService.enqueueWork(context, intentService)
        } else {
            val intentService = Intent(context, MyService::class.java)
            MyService.enqueueWork(context, intentService)

            val intentWatcher = Intent(context, TheWatcherJobService::class.java)
            TheWatcherJobService.enqueueWork(context, intentWatcher)
        }
    }
}