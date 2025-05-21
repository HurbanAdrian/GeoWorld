package com.example.geoworld.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.geoworld.R
import com.example.geoworld.data.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatsService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        CoroutineScope(Dispatchers.IO).launch {
            val db = AppDatabase.getInstance(applicationContext)
            val statsDao = db.playerStatsDao()

            val allStats = statsDao.getAllStatsBlocking()
            val topScore = allStats.maxOfOrNull { it.score } ?: 0

            // %1$d vlozit INT aby isl ocez StringFormat
            val message = getString(R.string.log_top_score, topScore)
            Log.d("STATS_SERVICE", message)

            stopSelf() // ukončí službu po dokončení
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}