package com.example.phu.bth7;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    EditText edtext;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtext  = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.btnback);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent myCallerIntent = getIntent();

        Bundle bundle = myCallerIntent.getExtras();

        double so1 = bundle.getDouble("so1");
        double so2 = bundle.getDouble("so2");
        double kq = so1+so2;
        edtext.setText("Dữ liệu nhận: \n"
                + "Số 1: " + so1 + "\nSố 2: " + so2
                + "\n\nKết quả = " +kq);

        bundle.putDouble("ketqua", kq);
        myCallerIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK,myCallerIntent);


    }

}
