package com.example.phu.bth6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Bai3 extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btn = (Button) findViewById(R.id.btnExit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai3.this);
                builder.setIcon(R.drawable.home)
                        .setTitle("Thoat")
                        .setMessage("Bạn có muốn thoát chương trình")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Bai3.this,"Bạn vừa chọn YES",Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });
    }
}
