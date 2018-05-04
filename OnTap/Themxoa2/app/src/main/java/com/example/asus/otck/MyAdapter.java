package com.example.asus.otck;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter{
    private Context context;
    private int resource; // Chứa giao diện
    private ArrayList<HinhAnh> arr = new ArrayList<HinhAnh>();
    public MyAdapter(@NonNull Context context, int resource, ArrayList<HinhAnh> arr) {
        super(context, resource, arr);
        this.context = context;
        this.resource = resource;
        this.arr = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View row = layoutInflater.inflate(resource, null); // GUI
        switch (resource){ // Chứa giao diện tùy chọn theo mong muốn
            case R.layout.custom_row: // Giao diện chính - cần lưu hình ảnh - thông tin
                ImageView img = row.findViewById(R.id.imgView);
                TextView name = row.findViewById(R.id.txtName);
                TextView size = row.findViewById(R.id.txtSize);

                HinhAnh item = arr.get(position);

                img.setImageResource(item.getImgID());
                name.setText(item.getImgName());
                size.setText(item.getImgSize());
                break;
            case R.layout.custom_row_dialog:   // Giao diện của dialog
                ImageView imgDialog = row.findViewById(R.id.imgCus_Dialog);
                TextView nameDialog = row.findViewById(R.id.txtCus_Dialog);

                HinhAnh itemDialog = arr.get(position);

                imgDialog.setImageResource(itemDialog.getImgID());
                nameDialog.setText(itemDialog.getImgID());
                break;
        }
        return row;
    }
}
