package com.example.dong.devpro_listview_add_edit_del;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapterSpinner extends BaseAdapter {
    private Context context;
    private int layout;
    private int[] picture;

    public CustomAdapterSpinner(Context context, int layout, int[] picture) {
        this.context = context;
        this.layout = layout;
        this.picture = picture;
    }
    @Override
    public int getCount() {
        return picture.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);

        ImageView img = (ImageView)view.findViewById(R.id.ID_pictueForSpinner);
        img.setImageResource(picture[position]);
        return view;
    }
}
