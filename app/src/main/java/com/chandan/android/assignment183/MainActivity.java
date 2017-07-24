package com.chandan.android.assignment183;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View view) {
        //prepare intent which is triggered if the
        //notification is selected
        Intent intent = new Intent(this,NotificationReceiverActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,
                (int)System.currentTimeMillis(),intent,0);

        //Build notification
        //Build a Notification using the NotificationCompat.Builder

        Notification notification = new Notification.Builder(this)
                .setStyle(new Notification.InboxStyle().addLine("LIne1")
                        .addLine("line2"))
                .setContentTitle("Inbox Style")
                .setContentText("This is a notification!")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pIntent)
                .build();
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        // Hide the notification afterr it's selected
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0,notification);
    }
}
