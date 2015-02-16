package com.project2.anything2.se329.puzzlarm.alarmmanagement;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.AlarmClock;

/**
 * Created by dj on 2/16/15.
 */
public class AlarmService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AlarmClockManagerHelper.setAlarms(this);
        return super.onStartCommand(intent, flags, startId);
    }
}
