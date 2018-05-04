package com.example.phu.bth7;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText x,y;
    Button btn;
    TextView txtkq;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 &&  resultCode == Activity.RESULT_OK)
        {
            Bundle myresultbundle = data.getExtras();
            Double kq = myresultbundle.getDouble("ketqua");
            txtkq.setText("Tổng = "+kq);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (EditText) findViewById(R.id.editso1);
        y = (EditText) findViewById(R.id.editso2);
        btn = (Button) findViewById(R.id.btntinh);
        txtkq = (TextView) findViewById(R.id.txtkq);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double so1 = Double.parseDouble(x.getText().toString());
                double so2 = Double.parseDouble(y.getText().toString());
                Intent myintent = new Intent(MainActivity.this,Second.class);

                Bundle mybundle = new Bundle();
                mybundle.putDouble("so1",so1);
                mybundle.putDouble("so2",so2);

                myintent.putExtras(mybundle);
                startActivityForResult(myintent,101);
            }
        });

    }
}
