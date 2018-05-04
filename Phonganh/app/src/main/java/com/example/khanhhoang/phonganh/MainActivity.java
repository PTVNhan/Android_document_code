package com.example.khanhhoang.phonganh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
 Button btnBack;
 ImageView imgSoloImage;
 GridView GridView;
 Bundle myBundle;
 Integer[] Hinhnho = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    Integer[] Hinhto = {R.drawable.s_image1,R.drawable.s_image2,R.drawable.s_image3,R.drawable.s_image4,
            R.drawable.s_image5,R.drawable.s_image6,R.drawable.s_image7,R.drawable.s_image8,R.drawable.s_image9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBundle=savedInstanceState;
        GridView = (GridView)findViewById(R.id.GridViewAnh);
        GridView.setAdapter(new MyImageAdapter(MainActivity.this,Hinhnho));
        GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showBigScreen(position);
                onDestroy();
            }
        });
    }
    private void showBigScreen(int position)
    {
        setContentView(R.layout.solo_picture);
        imgSoloImage= (ImageView)findViewById(R.id.solo_image);
        imgSoloImage.setImageResource(Hinhto[position]);
        btnBack = findViewById(R.id.solo_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myBundle);
            }
        });
    }
}
