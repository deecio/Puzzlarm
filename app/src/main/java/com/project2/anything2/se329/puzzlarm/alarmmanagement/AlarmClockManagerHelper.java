package com.project2.anything2.se329.puzzlarm.alarmmanagement;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dj on 2/16/15.
 */
public class AlarmClockManagerHelper extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        setAlarms(context);
    }

    public static void setAlarms(Context context) {

    }

    public static void cancelAlarms(Context context) {

    }

    private static PendingIntent createPendingIntent(Context context, AlarmModel model) {
        return null;
    }
}
