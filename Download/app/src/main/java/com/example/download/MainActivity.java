package com.example.download;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("TAG",getApplication().getFilesDir()+"/");
//        openDB();
//        createTable("create table tvd(id integer autoincrement,name text not null);");
//        insertTable("insert into tvd(name) values('tvd')");
//        String s=selectTable("select * from tvd;");
//        Log.v("TAG",s);
//        closeDB();
    }
    private void openDB(){
        File storagePath=getApplication().getFilesDir();
        try{
            db=SQLiteDatabase.openDatabase(storagePath+"/mysql",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void createTable(String query){
        db.beginTransaction();
        try{
            db.rawQuery(query,null);
            db.setTransactionSuccessful();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            db.endTransaction();
        }
    }
    private void insertTable(String query){
        db.beginTransaction();
        try {
            db.rawQuery(query,null);
            db.setTransactionSuccessful();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            db.endTransaction();
        }
    }
    private String selectTable(String query){
        db.beginTransaction();
        String s="";
        try{
            Cursor rs=db.rawQuery(query,null);
            rs.moveToPosition(-1);
            while(rs.moveToNext()){
                s+=rs.getString(rs.getColumnIndex("id"));
            }
            db.setTransactionSuccessful();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            db.endTransaction();
        }
        return s;
    }
    private void closeDB(){
        db.close();
    }
}
