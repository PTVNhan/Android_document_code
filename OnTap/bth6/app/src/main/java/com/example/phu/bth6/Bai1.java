package com.example.phu.bth6;

import android.app.ActionBar;
import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class Bai1 extends AppCompatActivity {

    EditText edtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        android.support.v7.app.ActionBar actionBar  = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.home);
        actionBar.setTitle("Action");
        edtMsg = (EditText) findViewById(R.id.editmsg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bai1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            edtMsg.setText("Search...");
            return true;
        }
        else if (id == R.id.action_share){
            edtMsg.setText("Share...");
            return true;
        }

        else if (id == R.id.action_about){
            edtMsg.setText("About...");
            return true;
        }
        else if (id == R.id.action_settings){
            edtMsg.setText("Setting...");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
