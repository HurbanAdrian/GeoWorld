package com.example.geoworld.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.geoworld.R

/**
 * Worker, ktorý zobrazuje dennú notifikáciu používateľovi ako pripomienku, že si ešte nezahral.
 *
 * Tento worker je naplánovaný pomocou WorkManager-u buď ako jednorazový, alebo periodický task.
 *
 * Notifikácia sa zobrazí po spustení pomocou `doWork()` a využíva NotificationManager a NotificationCompat.
 *
 * @constructor Vytvára ReminderWorker s daným [context] a parametrami [workerParams].
 */
class ReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    /**
     * Hlavná funkcia vykonávaná pri spustení worker-a.
     * Zavolá zobrazenie notifikácie a vráti úspešný výsledok.
     */
    override fun doWork(): Result {
        showNotification()
        return Result.success()
    }

    /**
     * Zobrazí notifikáciu používateľovi.
     *
     * Vytvorí notifikačný kanál (pre Android 8+), nastaví titulok, text a ikonu
     * a následne zaregistruje notifikáciu v NotificationManager-i.
     *
     * S pomcou chatGPT upravy
     * (applicationContext sa používa kvôli tomu, že Worker nemá prístup k Activity Context)
     */
    private fun showNotification() {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "reminder_channel"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = applicationContext.getString(R.string.notification_channel_name)
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(applicationContext.getString(R.string.notification_title))         //applicationContext lebo inac sa nedostaneme ku contextu alebo activity
            .setContentText(applicationContext.getString(R.string.notification_text))       // worker > context.getString
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // treba addnut permission
        notificationManager.notify(1001, builder.build())
    }
}