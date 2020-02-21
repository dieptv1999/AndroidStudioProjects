package com.example.listbased;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.List;

public class imageAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> images;
    public imageAdapter(Context mainContext,List<Integer> images){
        this.context=mainContext;
        this.images=images;
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return images.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView==null){
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridLayout.LayoutParams());
            imageView.setPadding(5,5,5,5);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(images.get(position));
        return imageView;
    }
}
