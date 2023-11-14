package com.example.privacypref_android

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "privacyNotificationChannel"
const val channelName = "privacyNotification"
@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {


    // Show Notification
    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("NotificationTitle", ""+ message.notification!!.title)
        if(message.notification != null){
             generateNotification(message.notification!!.title!!, message.notification!!.body!!)
        }
    }

    // Create Notification
    private fun getRmoteView(title: String, description: String): RemoteViews{
        val remoteView = RemoteViews("com.example.privacypref_android", R.layout.notificationlayout)
        remoteView.setTextViewText(R.id.titleNotify, title)
        remoteView.setTextViewText(R.id.descriptionNotify, description)
        remoteView.setImageViewResource(R.id.appLogo, R.drawable.notifyicon)
        return remoteView
    }
    private fun generateNotification(title: String, description: String){
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        // Create Channel ID and Name
        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.notifyicon)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 500, 1000, 500))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder = builder.setContent(getRmoteView(title, description))

        // Attach the Notification
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(notificationChannel)
        notificationManager.notify(0, builder.build())
    }



    // Display the notification

}