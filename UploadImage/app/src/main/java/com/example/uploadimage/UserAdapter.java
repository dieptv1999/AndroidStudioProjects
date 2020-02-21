package com.example.uploadimage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    Context context;
    List<Infomation> infos;

    public UserAdapter(Context context, List<Infomation> infos) {
        this.context = context;
        this.infos = infos;
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return infos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView=inflater.inflate(R.layout.single_user_item,parent,false);
            holder=new ViewHolder();
            holder.name=convertView.findViewById(R.id.id_username);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        final Infomation info=infos.get(position);
        if (holder!=null) {
            holder.name.setText(info.getName());
        }
        return convertView;
    }
    private class ViewHolder{
        TextView name;
    }
}
