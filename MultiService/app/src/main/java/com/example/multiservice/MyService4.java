package com.example.multiservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService4 extends Service {
    public static boolean boolIsServiceCreated = false;
    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "MyService4 Created", Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onCreate");
        boolIsServiceCreated = true;
        player = MediaPlayer.create(getApplicationContext(),
                R.raw.good_bad_ugly);
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService4 Stopped", Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onDestroy");
        player.stop();
        player.release();
        player = null;
    }
    @Override
    public void onStart(Intent intent, int startid) {
        if (player.isPlaying())
            Toast.makeText(this, "MyService4 Already Started " + startid,
                    Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "MyService4 Started " + startid,
                    Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onStart");
        player.start();
    }
}
