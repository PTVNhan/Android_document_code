package com.example.dong.devpro_listview_add_edit_del;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Dong on 6/6/2016.
 */
public class AddpersonActivity extends AppCompatActivity {
    TextView edtAddName, edtAddAddress, edtAddphone;
    Button btnAdd;
    int pos;
    Integer[] Hinhnho = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person);
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

                    Person person = new Person(pos, Hinhnho[pos++], edtAddName.getText().toString(),
                            edtAddAddress.getText().toString(), edtAddphone.getText().toString());
                    Intent intent = new Intent(AddpersonActivity.this, MainActivity.class);
                    intent.putExtra("ADD", person);
                    setResult(100, intent);
                    finish();

            }
        });
    }
}
