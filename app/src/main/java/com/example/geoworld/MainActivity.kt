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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoWorldTheme {
                val navController = rememberNavController()
                GeoWorldNavHost(navController = navController)

                val context = this
                val request = OneTimeWorkRequestBuilder<ReminderWorker>()
                    .setInitialDelay(5, TimeUnit.SECONDS)
                    .build()

                WorkManager.getInstance(context).enqueue(request)

                val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(1, TimeUnit.DAYS)
                    .setInitialDelay(12, TimeUnit.HOURS)
                    .build()

                WorkManager.getInstance(this).enqueueUniquePeriodicWork(
                    "daily_reminder",
                    ExistingPeriodicWorkPolicy.KEEP,
                    workRequest
                )
            }
        }
    }
}