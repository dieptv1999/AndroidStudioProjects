package com.example.connectdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDB();
        AlertDialog d=new AlertDialog.Builder(MainActivity.this).create();
        d.show();
//        createTable();
//        findAll();
        simmpleQuery();
        closeDB();
    }
    SQLiteDatabase db;
    private void openDB(){
        try {
            String filePath = getApplication().getFilesDir() + "/mysql";
            db = SQLiteDatabase.openDatabase(filePath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        }catch (Exception ex){
            ex.printStackTrace();
            Log.v("TAG",ex.toString());
        }
    }
    private void createTable(){
        db.beginTransaction();
        try{
            String query="CREATE TABLE VD1(id integer primary key autoincrement,name text,phone text)";
            db.execSQL(query);
            db.execSQL("insert into VD1(name,phone) values ('123','234')");
            db.setTransactionSuccessful();
            Log.v("TAG","DONE");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally {
            db.endTransaction();
        }
    }
    private void closeDB(){
        db.close();
    }
    public void findAll(){
        String query="Select * from VD1";
        Cursor rs=db.rawQuery(query,null);
        rs.moveToPosition(-1);
        while (rs.moveToNext()){
            int id=rs.getInt(0);
            String name=rs.getString(1);
            String phone=rs.getString(2);
            Log.v("TAG",id+name+phone);
        }
    }
    private void simmpleQuery(){
        String columns[]={"name","phone"};
        try {
            Cursor rs=db.query("VD1", columns, null, null, null, null, null);
            rs.moveToPosition(-1);
            TextView view1=findViewById(R.id.view1);
            Intent intent =new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0987654321");
            intent.putExtra("sms","abc");
            if (rs.moveToNext()) {
                Toast myToast=Toast.makeText(getApplicationContext(),"HÊre",Toast.LENGTH_LONG);
                view1.setText(rs.getString(rs.getColumnIndex("name")));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
