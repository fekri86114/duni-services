package info.fekri

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever.BitmapParams
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat

class LogcatService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1001, createNotification(applicationContext))
        Thread.sleep(8000)
        stopSelf()
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        stopForeground(true)
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun createNotification(con: Context): Notification {

        val notification = NotificationCompat.Builder(con, "myNotif")
            .setSmallIcon(android.R.drawable.stat_notify_error)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.img_android))
            .setContentTitle("Duni Services")
            .setContentText("This is a test-notification")
            .build()

        return notification
    }

}