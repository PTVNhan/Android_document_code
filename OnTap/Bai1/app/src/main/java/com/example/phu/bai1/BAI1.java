package com.example.phu.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BAI1 extends AppCompatActivity {

    Button btndangnhap;
    EditText txtuser,txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        txtuser = (EditText) findViewById(R.id.editusername);
        txtpassword = (EditText) findViewById(R.id.editpasss);
        btndangnhap = (Button) findViewById(R.id.btnlogin);

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtuser.getText().toString().equals("phudiva") && txtpassword.getText().toString().equals("123456"))
                {
                    Toast.makeText(BAI1.this,"Welcome to " + txtuser.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(BAI1.this,"User|Password not available",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
