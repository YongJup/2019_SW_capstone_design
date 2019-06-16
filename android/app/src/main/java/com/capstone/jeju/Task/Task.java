package com.capstone.jeju.Task;

import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.capstone.jeju.Fragment.MiseFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Task extends AsyncTask<String, String, String> {
    private String clientKey = "1ac4lEiHlInQVr1qCc1dJ8H4P1PTW%2Fm%2BBW9DGCIJjE121q3w9B8BW9xwgS6MHhlxH7z8o8wyOqXvyE5ebc97uQ%3D%3D";
    private String str, receiveMsg;
    private MiseFragment fragment;

    public Task(MiseFragment fragment) {
        super();
        this.fragment = fragment;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey="+clientKey+"&sidoName=제주&ver=1.3&_returnType=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("x-waple-authorization", clientKey);

            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();
                Log.i("receiveMsg : ", receiveMsg);

                reader.close();
            } else {
                Log.i("통신 결과", conn.getResponseCode() + "에러");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiveMsg;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        fragment.setMise(s);
    }
}
