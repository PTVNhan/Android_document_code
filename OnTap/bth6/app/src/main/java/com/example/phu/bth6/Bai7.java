package com.example.phu.bth6;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai7 extends AppCompatActivity {

    Button btndangnhap;
    EditText Username;
    EditText Password;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);


        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(Bai7.this);
                dialog.setContentView(R.layout.signing);
                dialog.setTitle("Đăng nhập");
                Username = (EditText) dialog.findViewById(R.id.txtusername);
                Password = (EditText) dialog.findViewById(R.id.txtpassword);
                Button btndy = (Button) dialog.findViewById(R.id.btnsign);
                Button btnhuy = (Button) dialog.findViewById(R.id.btncancel);
                btndy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.setCanceledOnTouchOutside(false);
                        String username = Username.getText().toString().trim();
                        String password = Password.getText().toString().trim();
                        if(username.equals("phu") && password.equals("123456")){
                            Toast.makeText(Bai7.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Bai7.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
            }

        });
    }
}
