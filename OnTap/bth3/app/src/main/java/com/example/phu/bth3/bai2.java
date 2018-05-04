package com.example.phu.bth3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class bai2 extends AppCompatActivity {

    ListView from, to;
    EditText txtfrom, txtto;
    String giatribandau = "";
    String giatrisau = "";
    Double sobandau = 0.0;
    String [] Conver1 = {"Meter","Kilometer","Centimeter","Millimeter","a","b","c","d","e","f"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        from = (ListView) findViewById(R.id.listviewfrom);
        to = (ListView) findViewById(R.id.listviewto);
        txtfrom = (EditText) findViewById(R.id.edittextfrom);
        txtto = (EditText) findViewById(R.id.edittextto);
        setTitle("Phú");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(bai2.this,android.R.layout.simple_list_item_1,Conver1);
        from.setAdapter(adapter);
        to.setAdapter(adapter);

        from.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                giatribandau = Conver1[position];
            }
        });
        to.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                giatrisau = Conver1[position];
            }
        });

        txtfrom.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtfrom.length() == 0)
                {
                    txtto.setText("");
                }
                else
                {
                    sobandau = Double.parseDouble(txtfrom.getText().toString());
                    txtto.setText(String.valueOf(Convert(giatribandau,giatrisau,sobandau)));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private double Convert(String input, String output, double x)
    {
        double kq = 0;
        if(input.equals("Meter"))
        {
            if(output.equals("Centimeter"))
            {
                kq =  x * 10;
            }
            else if(output.equals("Millimeter"))
            {
                kq =  x * 100;
            }
        }
        else
        {
            kq = x;
        }
        return kq;
    }
}
