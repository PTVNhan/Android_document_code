package com.example.phu.bth4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Phu on 4/26/2018.
 */
public class MyAdapter_bai1 extends ArrayAdapter {

    Context context;
    ArrayList<Person> person = new ArrayList<Person>();
    String [] object;
    public MyAdapter_bai1(Context context, int resource, ArrayList<Person> person) {
        super(context, R.layout.layout_person, person);
        this.context = context;
        this.person  =  person;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (((Activity)context).getLayoutInflater());
        View row = inflater.inflate(R.layout.layout_person,null);

        TextView txtuser = (TextView) row.findViewById(R.id.txtname);
        TextView txtsdt = (TextView) row.findViewById(R.id.txtsdt);

        txtuser.setText(person.get(position).getName().toString());
        txtsdt.setText(person.get(position).getSdt().toString());
        return row;
    }
}
