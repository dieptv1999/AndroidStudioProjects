package com.example.multiservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtMsg;
    Intent intentCallService4;
    Intent intentCallService5;
    Intent intentCallService6;
    BroadcastReceiver receiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        findViewById(R.id.btnStart4).setOnClickListener(this);
        findViewById(R.id.btnStop4).setOnClickListener(this);
        findViewById(R.id.btnStart5).setOnClickListener(this);
        findViewById(R.id.btnStop5).setOnClickListener(this);
        findViewById(R.id.btnStart6).setOnClickListener(this);
        findViewById(R.id.btnStop6).setOnClickListener(this);
        Log.e("MAIN", "Main started");
// get ready to invoke execution of background services
        intentCallService4 = new Intent(this, MyService4.class);
        intentCallService5 = new Intent(this, MyService5Async.class);
        intentCallService6 = new Intent(this, MyService6.class);
// register local listener & define triggering filter
        IntentFilter filter5 = new IntentFilter("matos.action.GOSERVICE5");
        IntentFilter filter6 = new IntentFilter("matos.action.GPSFIX");
        receiver = new MyEmbeddedBroadcastReceiver();
        registerReceiver(receiver, filter5);
        registerReceiver(receiver, filter6);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart4) {
            Log.e("MAIN", "onClick: starting service4");
            startService(intentCallService4);
        } else if (v.getId() == R.id.btnStop4) {
            Log.e("MAIN", "onClick: stopping service4");
            stopService(intentCallService4);
        } else if (v.getId() == R.id.btnStart5) {
            Log.e("MAIN", "onClick: starting service5");
            startService(intentCallService5);
        } else if (v.getId() == R.id.btnStop5) {
            Log.e("MAIN", "onClick: stopping service5");
            stopService(intentCallService5);
        } else if (v.getId() == R.id.btnStart6) {
            Log.e("MAIN", "onClick: starting service6");
            startService(intentCallService6);
        } else if (v.getId() == R.id.btnStop6) {
            Log.e("MAIN", "onClick: stopping service6");
            stopService(intentCallService6);
        }
    }
    public class MyEmbeddedBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("MAIN>>>", "ACTION: " + intent.getAction());
            if (intent.getAction().equals("matos.action.GOSERVICE5")) {
                String service5Data = intent.getStringExtra("MyService5DataItem");
                Log.e("MAIN>>>", "Data received from Service5: " + service5Data);
                txtMsg.append("\nService5Data: > " + service5Data);
            } else if (intent.getAction().equals("matos.action.GPSFIX")) {
                double latitude = intent.getDoubleExtra("latitude", -1);
                double longitude = intent.getDoubleExtra("longitude", -1);
                String provider = intent.getStringExtra("provider");
                String service6Data = provider
                        + " lat: " + Double.toString(latitude)
                        + " lon: " + Double.toString(longitude);
                Log.e("MAIN>>>", "Data received from Service6: " + service6Data);
                txtMsg.append("\nService6Data: > " + service6Data);
            }
        }//onReceive
    }
}
