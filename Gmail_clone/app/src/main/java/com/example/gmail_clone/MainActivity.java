package com.example.gmail_clone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d93025")));
        bar.setDisplayShowHomeEnabled(true);
        bar.setIcon(R.drawable.ic_narbar);
        bar.setDisplayUseLogoEnabled(true);
        bar.setTitle("  Inbox");
        messages=new ArrayList<>();
        for (char i='A';i<='Z';++i){
            messages.add(new Message(0,String.valueOf(i)+"durila.com","First 10 spots","contact1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","26/09/2019"));
        }
        //messages.add(new Message(0,"Adurila.com","First 10 spots","contact1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","26/09/2019"));
        //messages.add(new Message(1,"Bdurila.com","First 10 spots","contact1aaaaaaaaaaaaaaaaaaaaa","26/09/2019"));
        //messages.add(new Message(2,"Cdurila.com","First 10 spots","contact1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","26/09/2019"));
        //messages.add(new Message(3,"Ddurila.com","First 10 spots","contact1","26/09/2019"));
        MessageAdapter adapter=new MessageAdapter(this,messages);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
