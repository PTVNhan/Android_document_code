package com.example.phu.bth5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Phu on 4/26/2018.
 */
public class MyImageAdapter_bai3 extends BaseAdapter {


    public MyImageAdapter_bai3(Context context, Integer[] image) {
        this.context = context;
        Image = image;
    }

    private Context context;
    Integer[] Image;
    @Override
    public int getCount() {
        return Image.length;
    }

    @Override
    public Object getItem(int position) {
        return Image[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 75)); // canh lại chiều dài + rộng của hình
            imageView.setScaleType(ImageView.ScaleType.CENTER); // canh cho hình nằm giữa
            imageView.setPadding(5, 5, 5, 5);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(Image[position]);
        return imageView;
    }
}
