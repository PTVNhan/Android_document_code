package com.example.phu.bth6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai2 extends AppCompatActivity {

    TextView txtmsg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        btn = (Button) findViewById(R.id.btnalert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Bai2.this);
                builder.setTitle("Thoát")
                        
                        .setIcon(R.drawable.exit)
                        .setMessage("Bạn có muốn thoát chương trình?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtmsg.setText("YES" + which);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtmsg.setText("No" + which);
                            }
                        }).show();

            }
        });
    }
}
