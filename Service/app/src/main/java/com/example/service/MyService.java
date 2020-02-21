package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public void onStart(Intent intent, int startId) {
        Log.v("TAG", "I am alive-1!");
        Log.v ("TAG", "I did something");
    }
    @Override
    public void onDestroy() {
        Log.v("TAG", "I am dead-1");
    }
}
