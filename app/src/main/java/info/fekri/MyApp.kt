package info.fekri

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("myNotif", "TestChannel", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            notificationChannel.description = "This channel is for DuniService. I crated this channel as a test Channel."
            notificationManager.createNotificationChannel(notificationChannel)
        }

    }

}