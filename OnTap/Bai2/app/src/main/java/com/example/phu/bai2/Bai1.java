package com.example.phu.bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Bai1 extends AppCompatActivity {

    TextView txt;
    Button btntrue,btnfalse;
    ArrayList<String> Questions = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        txt = (TextView) findViewById(R.id.txtmsg);
        btntrue = (Button) findViewById(R.id.btntrue);
        btnfalse = (Button) findViewById(R.id.btnfalse);

        Questions.add(0, "bạn có phải tên Nhã không?");
        Questions.add(1, "You crazy?");

        for(int i = 0 ; i <= 1;  i++)
        {
            txt.setText(Questions.get(i).toString());
            btntrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bai1.this, "bạn trả lời đúng", Toast.LENGTH_SHORT).show();
                }
            });
            btnfalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Bai1.this,"bạn trả lời sai",Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}
