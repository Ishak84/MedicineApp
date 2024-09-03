package com.geeks.medicineapp.receiver

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.geeks.medicineapp.R

class AlarmReceiver : BroadcastReceiver() {
    companion object {
        private const val CHANNEL_ID = "pillstime_channel_id"
        private const val NOTIFICATION_ID = 1001
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        showNotification(context)
    }

    @SuppressLint("MissingPermission")
    private fun showNotification(context: Context?) {
        createNotificationChannel(context)

        val builder = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_pills)
            .setContentTitle("Пора принять таблетку!")
            .setContentText("Не забудьте принять свои лекарства.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }

    private fun createNotificationChannel(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "PillsTime Notifications"
            val descriptionText = "Уведомления для приложения PillsTime"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
            }
            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}