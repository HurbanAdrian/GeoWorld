package com.example.geoworld.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.geoworld.R

/**
 * BroadcastReceiver na zachytenie neaktivity používateľa – konkrétne, keď dôjde k vypnutiu obrazovky.
 *
 * Využíva sa na zisťovanie, kedy používateľ prestal hrať, čím sa dá napríklad logovať.
 *
 * Tento receiver je registrovaný na `Intent.ACTION_SCREEN_OFF`, teda reaguje na vypnutie displeja.
 */
class InactivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_SCREEN_OFF) {
            context?.let {
                Log.d("BROADCAST", it.getString(R.string.log_inactivity))
            }
        }
    }
}