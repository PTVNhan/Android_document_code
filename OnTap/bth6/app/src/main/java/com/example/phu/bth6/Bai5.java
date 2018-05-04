package com.example.phu.bth6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bai5 extends AppCompatActivity {


    Button btn;
    boolean[] checkedDays = new boolean[] {
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };

    String select = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        btn = (Button) findViewById(R.id.btnDay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai5.this);
                select = "";
                builder.setMultiChoiceItems(R.array.days, checkedDays, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked == true)
                        {
                             select += Integer.toString(which+2);

                        }
                    }
                })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Bai5.this,"Thứ " + select+",",Toast.LENGTH_SHORT).show();
                                checkedDays = new boolean[]{false,
                                        false,
                                        false,
                                        false,
                                        false,
                                        false,
                                        false};
                            }
                        }).show();
            }
        });

    }}
