package com.example.phu.bth3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class bai1 extends AppCompatActivity {

    EditText usd,vnd;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        usd = (EditText) findViewById(R.id.edittextUSD);
        vnd = (EditText) findViewById(R.id.edittextVND);
        btn1 = (Button) findViewById(R.id.btnclear);
        btn2 = (Button) findViewById(R.id.btnconvert);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double  dolar = Double.parseDouble(usd.getText().toString());
                vnd.setText("$"+ String.valueOf(Chuyentien((dolar))));

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usd.setText(null);
                vnd.setText(null);
            }
        });


    }

    private double Chuyentien(double usd)
    {
        return (usd*20.000);
    }
}
