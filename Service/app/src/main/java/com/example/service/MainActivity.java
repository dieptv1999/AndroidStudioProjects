package com.example.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Intent intent;
    ComponentName service;
    TextView txtMsg;

    Button btnDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg=findViewById(R.id.txtMsg);
        btnDownload=findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(this);
        intent=new Intent(this,MyService.class);
        service=startService(intent);
        Log.v("TAG","Start");
    }

    @Override
    public void onClick(View v) {
        try {
            stopService(intent);
            txtMsg.setText("After stopping Service: \n" + service.getClassName());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
