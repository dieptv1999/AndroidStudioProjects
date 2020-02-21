package com.example.listbased;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HorizontalScrollView scroll_=findViewById(R.id.horizontal_scroll);
        ViewGroup view=findViewById(R.id.view_group);
        ImageView imageSelected=findViewById(R.id.image_selected);
        Integer[] images={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
        for (int i=0;i<images.length;++i){
            View singleFrame=getLayoutInflater().inflate(R.layout.activity_main,null);
            singleFrame.setId(i);
            ImageView image=singleFrame.findViewById(R.id.imageView);
            TextView caption=singleFrame.findViewById(R.id.caption);
            caption.setText("hello");
            image.setImageResource(images[i]);
            view.addView(singleFrame);
        }
    }
}
