package com.example.nhanphan.personlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class EditActivity2 extends AppCompatActivity {

    ImageView imgEditAvatar;
    EditText edtEditName, edtEditAddress, edtEditPhone;
    Button btnSaveEdit, btnExitEdit, btnDel ,btLay;
    Person person;
    int path;

    Spinner spinner;
    int[] Hinhnho = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    int pathImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);
        imgEditAvatar = (ImageView) findViewById(R.id.imgEditAvatar);
        btLay= (Button) findViewById(R.id.buttonThem);
        // Gọi phương thức ivitView và getData
        spinner =(Spinner) findViewById(R.id.spin);
        CustomAdapterSpinner customAdapterSpinner = new CustomAdapterSpinner(EditActivity2.this,R.layout.spinner_layout,Hinhnho);
        spinner.setAdapter(customAdapterSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                pathImg = spinner.getSelectedItemPosition();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgEditAvatar.setImageResource(Hinhnho[pathImg]);
            }
        });

        initView();
        getData();
    }
    // Khởi tạo initView
    private void initView() {



        edtEditName = (EditText) findViewById(R.id.edtEditName);
        edtEditAddress = (EditText) findViewById(R.id.edtEditAddress);
        edtEditPhone = (EditText) findViewById(R.id.edtEditPhone);
        btnExitEdit = (Button) findViewById(R.id.btnExitEdit);
        btnSaveEdit = (Button) findViewById(R.id.btnEdit);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnSaveEdit.setOnClickListener(SaveEdit_Click);
        btnExitEdit.setOnClickListener(Exit_Edit);
        btnDel.setOnClickListener(Del_Click);
    }

    // Khơi tạo getData
    private void getData() {
        if (getIntent().getExtras() != null) {
            person = (Person) getIntent().getSerializableExtra("EDIT");
            int a = person.getCode();
            imgEditAvatar.setImageResource(person.getAvatar());
            edtEditName.setText(person.getName());
            edtEditAddress.setText(person.getAddress());
            edtEditPhone.setText(person.getPhone());
        }
    }

    View.OnClickListener SaveEdit_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity2.this, MainActivity.class);
            int b = person.getCode();



            //adapter = new PersonAdapter(new ArrayAdapter<String>(list, EditActivity.this);
            //ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Hinhnho);
            //spinner.setAdapter(list);
            Person person1 = new Person(b, Hinhnho[pathImg],
                    edtEditName.getText().toString(), edtEditAddress.getText().toString(), edtEditPhone.getText().toString());
            intent.putExtra("EDIT", person1);
            setResult(200, intent);
            finish();
        }
    };
    View.OnClickListener Del_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity2.this, MainActivity.class);
            intent.putExtra("DEL", person.getCode());
            setResult(300, intent);
            finish();
        }
    };
    View.OnClickListener Exit_Edit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}

