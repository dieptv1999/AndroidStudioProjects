package com.example.async;

import android.content.Context;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<AppCompatActivity,Void,Void> {

    @Override
    protected Void doInBackground(AppCompatActivity ...args) {
        try {
            URL url = new URL("https://data.chiasenhac.com/dataxx/16/downloads/1021/2/1020691-46ae8508/128/Happy%20New%20Year%20-%20ABBA.mp3");
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode=conn.getResponseCode();
            InputStream input=conn.getInputStream();
            File file=new File(args[0].getApplication().getFilesDir(),"test.mp3");
            //FileOutputStream outputStream =openFileOutput("test.mp3", Context.MODE_PRIVATE);
            FileOutputStream outputStream=
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
