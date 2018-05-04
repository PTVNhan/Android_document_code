package com.example.phu.bth6;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bai8 extends AppCompatActivity {

    Button xacnhan;
    Dialog dialog;
    EditText hoten;
    RadioGroup Nganh;
    String Ngonnguyeuthich= "";
    String selectedNganh = "";
    String hovaten = "";

    CheckBox cb1,cb2,cb3,cb4,cb5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8);
        xacnhan = (Button) findViewById(R.id.btnxacnhan);
        hoten = (EditText) findViewById(R.id.edithoten);

        cb1 = (CheckBox) findViewById(R.id.cbCShap);
        cb2 = (CheckBox) findViewById(R.id.cbPython);
        cb3 = (CheckBox) findViewById(R.id.cbJava);
        cb4 = (CheckBox) findViewById(R.id.cbRuby);
        cb5 = (CheckBox) findViewById(R.id.cbCPP);
        Nganh = (RadioGroup) findViewById(R.id.RadioGroupNganh);






        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int id =  Nganh.getCheckedRadioButtonId();
                switch (id)
                {
                    case R.id.rbLaptrinh:selectedNganh += "Lập trình";break;
                    case R.id.rbMang: selectedNganh+="Mang";break;
                }
                if(R.id.rbLaptrinh == 1)

                if(cb1.isChecked() == true)
                    Ngonnguyeuthich += "C-Shap ,";
                if(cb2.isChecked() == true)
                    Ngonnguyeuthich += "Python ,";

                if(cb3.isChecked() == true)
                    Ngonnguyeuthich += "Java ,";

                if(cb4.isChecked() == true)
                    Ngonnguyeuthich += "Ruby ,";

                if(cb5.isChecked() == true)
                    Ngonnguyeuthich += "CPP ,";
                hovaten = hoten.getText().toString();

                Thongtincanhan thongtincanhan = new Thongtincanhan(hovaten, Ngonnguyeuthich, hovaten + "@gmail.com", selectedNganh);
                dialog = new Dialog(Bai8.this);
                dialog.setContentView(R.layout.thongtincanhan);
                //Ánh xạ

                TextView txtHoten = (TextView) dialog.findViewById(R.id.txthoten);
                TextView txtEmail = (TextView) dialog.findViewById(R.id.txtemail);
                TextView txtNgonngu = (TextView) dialog.findViewById(R.id.txtNgonngu);
                TextView txtNganh = (TextView) dialog.findViewById(R.id.txtNganh);

                txtHoten.setText(thongtincanhan.getHoten());
                txtNgonngu.setText(thongtincanhan.getNNYT());
                txtEmail.setText(thongtincanhan.getEmail());
                txtNganh.setText(thongtincanhan.getNganh());
                dialog.show();


            }
        });

    }
}
