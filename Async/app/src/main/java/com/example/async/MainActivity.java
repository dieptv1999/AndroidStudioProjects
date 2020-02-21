package com.example.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSlowTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSlowTask=findViewById(R.id.btnSlowTask);
        btnSlowTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new SlowTask().execute(100);
                
            }
        });
    }
}
