package com.example.phu.bth4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class bai1 extends Activity {

    ListView mylist;
    TextView txt;
    String [] item = {"Cơ sở dữ liệu","Cơ sở lập trình","Cầu trúc dữ liệu","Lập trình hướng đối tượng"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        mylist = (ListView) findViewById(R.id.listview_bai1);
        txt = (TextView) findViewById(R.id.txtmsg_bai1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(bai1.this,android.R.layout.simple_list_item_1,item);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Position " + position + " : " + item[position]);
            }
        });

    }


}
