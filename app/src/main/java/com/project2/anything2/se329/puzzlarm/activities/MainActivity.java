package com.project2.anything2.se329.puzzlarm.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.project2.anything2.se329.puzzlarm.R;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private int currentSelection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        if(layoutResID != R.layout.activity_main)
            setMyContentView(layoutResID);
    }

    protected void setMyContentView(int resid){
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        LayoutInflater inflater = LayoutInflater.from(this);
        container.addView(inflater.inflate(resid,null,false));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        if(position!= currentSelection) {
            Intent myIntent;
            switch (position) {
                case 0:
                    myIntent = new Intent(this, SetAlarmActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    startActivity(myIntent);
                    break;
                case 1:
                    myIntent = new Intent(this, DiviceManagementActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    startActivity(myIntent);
                    break;
                case 2:
                    myIntent = new Intent(this, PuzzleActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    startActivity(myIntent);
                    break;
                case 3:
                     myIntent = new Intent(this, LogInOutActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    startActivity(myIntent);
                    break;

            }
            currentSelection = position;
        }
    }



    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    @Override
    public void onBackPressed() {
        finish();
    }
}
