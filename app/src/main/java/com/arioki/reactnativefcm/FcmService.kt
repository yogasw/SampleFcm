package com.arioki.reactnativefcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


/**
 * Created on : 19/04/20
 * Author     : arioki
 * Name       : Yoga Setiawan
 * GitHub     : https://github.com/arioki
 */
class FcmService : FirebaseMessagingService() {
    override fun onNewToken(p0: String) {
        Log.d("LOG_APP", p0)
        super.onNewToken(p0)
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        val intent = Intent(App.context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        App.context.startActivity(intent)
        createNotification(p0.data)
    }


    private fun createNotification(data: MutableMap<String, String>) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            } else {
                ""
            }

        val notificationIntent = Intent(this, MainActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            101,
            notificationIntent,
            0
        )
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(data[1.toString()])
            .setContentText("content")
            .setSound(null)
            .setDefaults(0)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
            .setColor(ContextCompat.getColor(this, R.color.colorAccent))
            .setContentIntent(pendingIntent)
            .build()
        notificationManager.notify(101, notification)
        FcmPref.setOpenActivity(true)
        //startForeground(101, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(): String {
        val chan = NotificationChannel("101", "PUSH NOTIF", NotificationManager.IMPORTANCE_NONE)
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return "101"
    }
}