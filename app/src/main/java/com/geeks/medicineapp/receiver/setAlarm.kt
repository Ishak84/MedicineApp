package com.example.pillstime.receiver

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.geeks.medicineapp.receiver.AlarmReceiver

@SuppressLint("ScheduleExactAlarm")
fun setAlarm(context: Context, timeInMillis: Long) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(context, 0,intent, PendingIntent.FLAG_IMMUTABLE)

    alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
}