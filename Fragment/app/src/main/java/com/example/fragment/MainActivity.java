package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainCallBacks{
    FragmentTransaction ft;
    RedFragment rf;
    BlueFragment bf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ft = getSupportFragmentManager().beginTransaction();
        bf = BlueFragment.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, bf);
        ft.commit();
        ft = getSupportFragmentManager().beginTransaction();
        rf = RedFragment.newInstance("first-red");
        ft.replace(R.id.main_holder_red, rf);
        ft.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
        Toast.makeText(getApplication(),
                " MAIN GOT>> " + sender + "\n" + strValue, Toast.LENGTH_LONG)
                .show();
        if (sender.equals("RED-FRAG")) {
        }
        if (sender.equals("BLUE-FRAG")) {
            try {
                rf.onMsgFromMainToFragment("\nSender: " + sender
                        + "\nMsg: " + strValue);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
    }
}
