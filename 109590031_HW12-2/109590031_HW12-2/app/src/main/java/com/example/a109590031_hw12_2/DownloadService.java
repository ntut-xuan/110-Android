package com.example.a109590031_hw12_2;

import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class DownloadService extends JobService {

    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    Context context = MainActivity.getAppContext();
    NotificationManager notificationManager;

    public DownloadService(){

    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        sendNotification();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    private void sendNotification(){
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        System.out.println("Start Work");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_download_24)
                .setContentTitle("Performing Work")
                .setContentText("Download in Progress")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
