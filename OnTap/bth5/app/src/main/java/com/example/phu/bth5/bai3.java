package com.example.phu.bth5;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class bai3 extends Activity {

    GridView mygrid;
    Bundle myoriginbundle;
    Button back;
    ImageView imgpicture;
    Integer [] Image = {R.drawable.hinh1,R.drawable.hinh2,R.drawable.hinh3,R.drawable.hinh4
    ,R.drawable.hinh5,R.drawable.hinh6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        myoriginbundle = savedInstanceState();
        mygrid = (GridView) findViewById(R.id.gridView_bai3);
        MyImageAdapter_bai3 adapter_bai3 = new MyImageAdapter_bai3(bai3.this,Image);
        mygrid.setAdapter(adapter_bai3);
        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Showpicture(position);
            }
        });

    }

    private Bundle savedInstanceState() {
        return null;
    }

    private void Showpicture(int position)
    {
        setContentView(R.layout.solo_picture);
        imgpicture = (ImageView) findViewById(R.id.img_solopicture);
        back = (Button) findViewById(R.id.btnBack);
        imgpicture.setImageResource(Image[position]);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myoriginbundle);
            }
        });
    }
}
