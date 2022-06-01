package com.example.a109590031_hw12_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;

    private static Context context;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public static Context getAppContext(){
        return context;
    }

    public void download(View view){
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), DownloadService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(0, componentName);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                    .setRequiresDeviceIdle(true)
                    .setRequiresCharging(true)
                    .setPeriodic(TimeUnit.DAYS.toMillis(1));
        JobInfo jobInfo = builder.build();
        if(jobScheduler != null){
            jobScheduler.schedule(jobInfo);
            Toast.makeText(this, "Scheduled!", Toast.LENGTH_LONG).show();
        }
    }

    private void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, PRIMARY_CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Download Notification");
            notificationManager.createNotificationChannel(notificationChannel);
            Toast.makeText(this, "Channel created!", Toast.LENGTH_LONG).show();
        }
    }


}