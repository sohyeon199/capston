package com.example.push2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Bitmap mLargeIconForNoti =
                        BitmapFactory.decodeResource(getResources(), R.drawable.image1);
                PendingIntent mPendingIntent = PendingIntent.getActivity(MainActivity.this, 0,
                        new Intent(getApplicationContext(), MainActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this, "channel_id")
                        .setSmallIcon(R.drawable.image0)
                        .setContentTitle(" 알림 제목 ")
                        .setContentText(" 알림 내용 ")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setLargeIcon(mLargeIconForNoti)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(mPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());
            }
        });
    }
}