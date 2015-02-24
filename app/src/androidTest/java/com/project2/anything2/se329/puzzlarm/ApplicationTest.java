package com.project2.anything2.se329.puzzlarm;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.provider.AlarmClock;
import android.test.ApplicationTestCase;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }



    public void testAlarmsSet(){
        ArrayList<Integer> dayzzzz = new ArrayList<>();
        dayzzzz.add(Calendar.SATURDAY);
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, 9);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 37);
        i.putExtra(AlarmClock.EXTRA_DAYS, dayzzzz);
//        startActivity(i);
    }
}