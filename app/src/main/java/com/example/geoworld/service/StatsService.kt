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

/**
 * Služba (`Service`), ktorá po ukončení hry načíta štatistiky z databázy a vypíše najvyššie skóre do logu.
 *
 * Spúšťa sa napr. pri detekcii, že hra skončila (`gameOver == true`) a slúži len na jednorazové pozadie.
 */
class StatsService : Service() {


    /**
     * Spustí službu na pozadí, načíta všetky štatistiky z Room databázy
     * a vypíše najvyššie dosiahnuté skóre do Logcatu.
     */
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

    /**
     * Nepodporujeme naviazanie (binding) – služba sa používa len ako jednoduchý fire-and-forget.
     * (fire-and-forget -> spustíš ju a necháš bežať, kým sa sama neukončí (stopSelf()))
     * (naviazanie klienta na službu)
     * S pomocou chatGPT
     */
    override fun onBind(intent: Intent?): IBinder? = null
}