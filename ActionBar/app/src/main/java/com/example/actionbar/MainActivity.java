package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    SearchView search;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg=findViewById(R.id.txtMsg);
        actionBar = getSupportActionBar();
        actionBar.setTitle("ActionBarDemo3");
        actionBar.setSubtitle("Version3.0");
        actionBar.setIcon(R.drawable.ic_launcher_background);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        search= (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "1-SUBMIT..." + query,
                        Toast.LENGTH_SHORT).show();
                invalidateOptionsMenu();
                search.setQuery("", false);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                txtMsg.append("\n2-CHANGE..." + newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_search:txtMsg.setText("search"); return true;
            case R.id.action_download
                    :txtMsg.setText("download"); return true;
            case R.id.action_share:txtMsg.setText("share"); return true;
        }
        return false;
    }
}
