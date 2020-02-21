package com.example.listuser;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    Context context;
    List<User> users;
    Gson gson=new Gson();

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView=inflater.inflate(R.layout.single_user_item,parent,false);
            holder=new ViewHolder();
            holder.id_username=convertView.findViewById(R.id.id_username);
            holder.name=convertView.findViewById(R.id.name);
            holder.email=convertView.findViewById(R.id.email);
            holder.street=convertView.findViewById(R.id.street);
            holder.suite=convertView.findViewById(R.id.suite);
            holder.city=convertView.findViewById(R.id.city);
            holder.zipcode=convertView.findViewById(R.id.zipcode);
            holder.lat=convertView.findViewById(R.id.lat);
            holder.lng=convertView.findViewById(R.id.lng);
            holder.phone=convertView.findViewById(R.id.phone);
            holder.website=convertView.findViewById(R.id.website);
            holder.company_name=convertView.findViewById(R.id.company_name);
            holder.company_catchPhrase=convertView.findViewById(R.id.company_catchPhrase);
            holder.company_bs=convertView.findViewById(R.id.company_bs);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        final User user=users.get(position);
        if (holder!=null) {
            holder.id_username.setText("id+username:"+user.getId()+"_"+user.getUsername());
            holder.name.setText("Name:"+user.getName());
            holder.street.setText("Street:"+user.getAddress().getStreet());
            holder.suite.setText("Suite:"+user.getAddress().getSuite());
            holder.city.setText("City:"+user.getAddress().getCity());
            holder.zipcode.setText("Code:"+user.getAddress().getZipcode());
            holder.lat.setText("Lat:"+user.getAddress().getGeo().getLat());
            holder.lng.setText("Lng:"+user.getAddress().getGeo().getLng());
            holder.email.setText("Email:"+user.getEmail());
            holder.phone.setText("Phone:"+user.getPhone());
            holder.website.setText("Website:"+user.getWebsite());
            holder.company_name.setText("Name:"+user.getCompany().getName());
            holder.company_catchPhrase.setText("catch_phrase:"+user.getCompany().getCatchPhrase());
            holder.company_bs.setText("Bs:"+user.getCompany().getBs());
        }
        return convertView;
    }
    private class ViewHolder{
        TextView id_username;
        TextView name;
        TextView email;
        TextView address;
        TextView street;
        TextView suite;
        TextView city;
        TextView zipcode;
        TextView geo;
        TextView lat;
        TextView lng;
        TextView phone;
        TextView website;
        TextView company;
        TextView company_name;
        TextView company_catchPhrase;
        TextView company_bs;
    }
}
