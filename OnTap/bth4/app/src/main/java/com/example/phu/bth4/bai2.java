package com.example.phu.bth4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class bai2 extends AppCompatActivity {

    EditText edtHoten,edtMa,edtSosachmuon,edtNgaymuon;
    RadioGroup rdg;
    Button btnAdd;
    ListView mylist;
    ArrayList<Person> listpersons = new ArrayList<Person>();
    String [] item = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edtHoten = (EditText) findViewById(R.id.edittextHoten);
        edtMa = (EditText) findViewById(R.id.edittextMa);
        edtSosachmuon = (EditText) findViewById(R.id.edittextSosachmuon);
        edtNgaymuon = (EditText) findViewById(R.id.edittextNgaymuon);
        mylist = (ListView) findViewById(R.id.lvDanhsachdocgia);

        btnAdd = (Button) findViewById(R.id.btnThem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtHoten.getText().toString();
                String sdt = edtMa.getText().toString();
                Person person = new Person(name,sdt);
                listpersons.add(person);
                MyAdapter_bai1 adapter_bai1 = new MyAdapter_bai1(bai2.this,R.layout.layout_person,listpersons);
                mylist.setAdapter(adapter_bai1);

            }
        });


    }
}
