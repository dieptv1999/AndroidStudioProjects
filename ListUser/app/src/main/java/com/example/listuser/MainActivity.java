package com.example.listuser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetTask().execute();
    }
    private class GetTask extends AsyncTask<Void, Void, Void> {

        @SuppressLint("WrongThread")
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/users");
                URLConnection con = url.openConnection();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String line;
                String builder = "";
                while ((line = reader.readLine()) != null) {
                    builder+=line;
                }
                reader.close();
                List<User> users=convertJSON(builder);
                UserAdapter adapter=new UserAdapter(MainActivity.this,users);
                ListView listView=findViewById(R.id.listView);
                listView.setAdapter(adapter);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
    public List<User> convertJSON(String listJSON){
        Gson gson = new Gson();
        File file=new File("");
        User[] result=gson.fromJson(listJSON,User[].class);
        return Arrays.asList(result);
    }
}
