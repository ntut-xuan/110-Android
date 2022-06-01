package com.example.a109590031_hw12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;

    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();

        Switch sw = findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
                PendingIntent contentPendingIntent = PendingIntent.getBroadcast(getBaseContext(), NOTIFICATION_ID, intent, 0);
                if(b){
                    long triggerTime = getAlarmTimeInMillis(11, 11);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, contentPendingIntent);
                    Toast.makeText(getBaseContext(), "Make a wish!", Toast.LENGTH_LONG).show();
                }else{
                    alarmManager.cancel(contentPendingIntent);
                    notificationManager.cancelAll();
                }
            }
        });

    }


    private long getAlarmTimeInMillis(int hour, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);//
        calendar.set(Calendar.SECOND, 0);
        if (calendar.getTimeInMillis() < System
                .currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+ 1);
        }
        return calendar.getTimeInMillis();
    }

    private void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, PRIMARY_CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Make a wish");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}