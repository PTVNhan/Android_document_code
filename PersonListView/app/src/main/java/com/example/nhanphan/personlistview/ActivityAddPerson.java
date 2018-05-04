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
import android.widget.TextView;

// Là một activity
public class ActivityAddPerson extends AppCompatActivity {
    TextView edtAddName, edtAddAddress, edtAddphone;
    Button btnAdd;
    int pos;
    Spinner spinner;
    ImageView imgEditAvatar;
    int pathImg;
    int[] Hinhnho = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person2); // Cách 2

        imgEditAvatar = (ImageView) findViewById(R.id.imgEditAvatar);
        spinner =(Spinner) findViewById(R.id.spin);
        CustomAdapterSpinner customAdapterSpinner = new CustomAdapterSpinner(ActivityAddPerson.this,R.layout.spinner_layout,Hinhnho);
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
        getSupportActionBar().hide();
        Intent intent = getIntent();
        pos = intent.getIntExtra("pos", 0);
        initview();
    }
    private void initview() {
        edtAddName = (EditText) findViewById(R.id.edtAddname);
        edtAddAddress = (TextView) findViewById(R.id.edtaddAddress);
        edtAddphone = (TextView) findViewById(R.id.edtAddPhone);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person person = new Person(pos++, Hinhnho[pathImg], edtAddName.getText().toString(),
                        edtAddAddress.getText().toString(), edtAddphone.getText().toString());
                Intent intent = new Intent(ActivityAddPerson.this, MainActivity.class);
                intent.putExtra("ADD", person);
                setResult(100, intent);
                finish();

            }
        });
    }
}
