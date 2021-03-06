package com.project2.anything2.se329.puzzlarm.activities;

import android.content.Intent;
import android.graphics.Color;
import android.provider.AlarmClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project2.anything2.se329.puzzlarm.R;

import java.util.ArrayList;
import java.util.Calendar;

public class SetAlarmActivity extends MainActivity implements View.OnClickListener {

    private TextView alarm;
    private EditText setTime;
    private Button sunday;
    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;
    private Button submit;
    private ArrayList<Integer> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        alarm = (TextView) findViewById(R.id.textClock);
        setTime = (EditText) findViewById(R.id.editText);
        sunday = (Button) findViewById(R.id.sun_button);
        monday = (Button) findViewById(R.id.mon_button);
        tuesday = (Button) findViewById(R.id.tues_button);
        wednesday = (Button) findViewById(R.id.wed_button);
        thursday = (Button) findViewById(R.id.thurs_button);
        friday = (Button) findViewById(R.id.fri_button);
        saturday = (Button) findViewById(R.id.sat_button);
        submit = (Button) findViewById(R.id.submitAlarm);

        days = new ArrayList<Integer>();

        sunday.setOnClickListener(this);
        monday.setOnClickListener(this);
        tuesday.setOnClickListener(this);
        wednesday.setOnClickListener(this);
        thursday.setOnClickListener(this);
        friday.setOnClickListener(this);
        saturday.setOnClickListener(this);
        submit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submitAlarm:
                //submit
                String time = setTime.getText().toString();
                //assum time in format HH:MM
                int hh = Integer.parseInt(time.split(":")[0]);
                int mm = Integer.parseInt(time.split(":")[1]);
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR, hh);
                i.putExtra(AlarmClock.EXTRA_MINUTES, mm);
                i.putExtra(AlarmClock.EXTRA_DAYS, days);
                startActivity(i);

                setTime.setText("");
                sunday.setBackgroundColor(Color.GRAY);
                monday.setBackgroundColor(Color.GRAY);
                tuesday.setBackgroundColor(Color.GRAY);
                wednesday.setBackgroundColor(Color.GRAY);
                thursday.setBackgroundColor(Color.GRAY);
                friday.setBackgroundColor(Color.GRAY);
                saturday.setBackgroundColor(Color.GRAY);
                days.removeAll(days);

                break;
            case R.id.sun_button:
                if(days.contains(Calendar.SUNDAY)){
                    sunday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.SUNDAY));
                }else{
                    sunday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.SUNDAY);
                }
                break;
            case R.id.mon_button:
                if(days.contains(Calendar.MONDAY)){
                    monday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.MONDAY));
                }else{
                    monday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.MONDAY);
                }
                break;
            case R.id.tues_button:
                if(days.contains(Calendar.TUESDAY)){
                    tuesday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.TUESDAY));
                }else{
                    tuesday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.TUESDAY);
                }
                break;
            case R.id.wed_button:
                if(days.contains(Calendar.WEDNESDAY)){
                    wednesday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.WEDNESDAY));
                }else{
                    wednesday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.WEDNESDAY);
                }
                break;
            case R.id.thurs_button:
                if(days.contains(Calendar.THURSDAY)){
                    thursday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.THURSDAY));
                }else{
                    thursday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.THURSDAY);
                }
                break;
            case R.id.fri_button:
                if(days.contains(Calendar.FRIDAY)){
                    friday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.FRIDAY));
                }else{
                    friday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.FRIDAY);
                }
                break;
            case R.id.sat_button:
                if(days.contains(Calendar.SATURDAY)){
                    saturday.setBackgroundColor(Color.GRAY);
                    days.remove(days.indexOf(Calendar.SATURDAY));
                }else{
                    saturday.setBackgroundColor(getResources().getColor(R.color.bg_red));
                    days.add(Calendar.SATURDAY);
                }
                break;
        }
    }
}
