package com.example.geoworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.geoworld.ui.navigation.GeoWorldNavHost
import com.example.geoworld.ui.theme.GeoWorldTheme
import com.example.geoworld.worker.ReminderWorker
import java.util.concurrent.TimeUnit

/**
 * Hlavná aktivita aplikácie GeoWorld.
 *
 * Zodpovedá za nastavenie základného UI pomocou Jetpack Compose a inicializáciu navigácie.
 * Taktiež plánuje jednorazový a periodický worker pomocou WorkManager-u,
 * ktorý slúži na pripomienku, že používateľ ešte nehral (notifikácia).
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Nastavenie Compose UI
        setContent {
            GeoWorldTheme {
                val navController = rememberNavController()
                // Inicializácia navigačného hostiteľa s definovanými obrazovkami
                GeoWorldNavHost(navController = navController)

                // Kontext pre WorkManager
                val context = this
                // Jednorazový worker: zobrazí notifikáciu 5 sekúnd po spustení aplikácie
                val request = OneTimeWorkRequestBuilder<ReminderWorker>()
                    .setInitialDelay(5, TimeUnit.SECONDS)
                    .build()

                WorkManager.getInstance(context).enqueue(request)
                // Periodický worker: zobrazí notifikáciu každých 24 hodín, s oneskorením 12 hodín po inštalácii
                val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(1, TimeUnit.DAYS)
                    .setInitialDelay(12, TimeUnit.HOURS)
                    .build()

                // ak už existuje, nebude sa duplikovať
                WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                    "daily_reminder",
                    ExistingPeriodicWorkPolicy.KEEP,
                    workRequest
                )
            }
        }
    }
}