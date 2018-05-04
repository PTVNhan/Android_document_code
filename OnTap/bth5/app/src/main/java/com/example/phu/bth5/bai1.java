package com.example.phu.bth5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class bai1 extends AppCompatActivity {

    Spinner myspinner;
    TextView txtmsg;
    String [] item =  {"Khoa Quản Trị Kinh Doanh",
    "Khoa Kế Toán Kiểm Toán",
    "Khoa Tài Chính - Ngân Hàng",
    "Khoa Kinh Tế và Luật",
    "Khoa Công Nghệ Thông Tin",
    "Khoa Công Nghệ Sinh Học"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        myspinner = (Spinner) findViewById(R.id.spinner);
        txtmsg = (TextView) findViewById(R.id.txtmsg_bai1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(bai1.this,android.R.layout.simple_spinner_dropdown_item,item);
        arrayAdapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        myspinner.setAdapter(arrayAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtmsg.setText(item[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
