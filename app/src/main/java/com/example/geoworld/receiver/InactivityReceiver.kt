package com.example.geoworld.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.geoworld.R

class InactivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_SCREEN_OFF) {
            context?.let {
                Log.d("BROADCAST", it.getString(R.string.log_inactivity))
            }
        }
    }
}