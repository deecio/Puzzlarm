package com.project2.anything2.se329.puzzlarm;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class httpRemote {

    private String url = "http://10.0.2.2:8080/remoteDBserver/server";
    private String user = "testuser2";
    private String pass = "testpassword";
    private String deviceID = "";

    public void register(String username, String password) {
        user = username;
        pass = password;
        reg remoteDB = new reg();
        remoteDB.execute("register");
    }

    public void registerDevice(String username, String password, String newDeviceID) {
        user = username;
        pass = password;
        deviceID = newDeviceID;
        reg remoteDB = new reg();
        remoteDB.execute("register-device");
    }

    public void startAlarm(String username, String password, String newDeviceID) {
        user = username;
        pass = password;
        deviceID = newDeviceID;
        reg remoteDB = new reg();
        remoteDB.execute("startAlarm");
    }
    public void stopAlarm(String username, String password, String newDeviceID) {
        user = username;
        pass = password;
        deviceID = newDeviceID;
        reg remoteDB = new reg();
        remoteDB.execute("stopAlarm");
    }

    private class reg extends AsyncTask<String, Integer, String> {

        protected void onProgressUpdate(Integer... progress) {
            // setProgressPercent(progress[0]);
        }

        protected void onPostExecute(String result1) {
            // result = result1;
        }

        protected String doInBackground(String... params) {
            // only ever recieves one name
            for (String condition : params) {
                // checks if network is up
                if (true) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost(url);
                    JSONObject json = new JSONObject();
                    // send data to server
                    try {
                        json.put("username", user);
                        json.put("password", pass);
                        json.put("condition", condition);
                        json.put("deviceID", deviceID);

                    } catch (Exception e) {
                        Log.e("rj", e.toString());
                    }
                }

            }
            return "";
        }
    }
}