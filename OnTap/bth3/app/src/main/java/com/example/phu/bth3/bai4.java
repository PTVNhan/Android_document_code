package com.example.phu.bth3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class bai4 extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3;
    CheckBox cb1,cb2;
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        setTitle("CafeApp");
        radioGroup = (RadioGroup) findViewById(R.id.rdgCoffee);

        cb1 = (CheckBox) findViewById(R.id.cbCream);
        cb2 = (CheckBox) findViewById(R.id.cbSugar);
        pay = (Button) findViewById(R.id.btnPay);

        pay.setOnClickListener(new View.OnClickListener() {
            String text = "";
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id)
                {
                    case R.id.rbDecaf:
                        text += "Decaf & ";break;
                    case R.id.rbColumbian:
                        text += "Columbian & ";break;
                    case R.id.rbExpresso:
                        text += "Expresso & ";break;
                }
                if (cb1.isChecked())
                    text += "Cream";
                if(cb2.isChecked())
                    text += " & Sugar";
                Toast.makeText(bai4.this,text,Toast.LENGTH_SHORT).show();
                text = "";
            }
        });
    }
}
