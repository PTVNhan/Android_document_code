package com.example.nhanphan.personlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    PersonAdapter adapter;
    ArrayList<Person> listData;
    ListView lvData;
    ImageView imgAddPerson;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        // Gọi phương thức getData và initView
        getData();
        initView();
    }
    View.OnClickListener Add_Click = new View.OnClickListener() { // Cách 2
        @Override
        public void onClick(View v) {
            Intent inte = new Intent(MainActivity.this, ActivityAddPerson.class);
            inte.putExtra("pos", pos++);
            startActivityForResult(inte, 10);
        }
    };
    private void initView() {
        adapter = new PersonAdapter(listData, MainActivity.this);
        lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        imgAddPerson = (ImageView) findViewById(R.id.imgAddPerson); // Cách 2
        imgAddPerson.setOnClickListener(Add_Click); // Cách 2
        // Sửa
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, EditActivity2.class);
                intent.putExtra("EDIT", adapter.getItem(i));
                startActivityForResult(intent, 20);
            }
        });

    }
    private void getData() {
        listData = new ArrayList<>();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                if (data !=  null){
                    Person person = (Person) data.getSerializableExtra("ADD");
                    if (resultCode == 100){
                       person.setCode(adapter.getCount() + 1);
                        adapter.getListData().add(0,person);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Có lỗi xảy ra, vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            case 20:
                if (data != null){
                    Person select = (Person) data.getSerializableExtra("EDIT");
                    if (resultCode ==  200){
                        for (Person item:adapter.getListData()){
                            if (item.getCode() == select.getCode()){
                                item.setAvatar(select.getAvatar());
                                item.setName(select.getName());
                                item.setAddress(select.getAddress());
                                item.setPhone(select.getPhone());
                                break;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    }else if (resultCode == 300){
                        int ID = data.getExtras().getInt("DEL");
                        int position = -1;
                        for (int i = 0; i < adapter.getCount(); i++){
                            if (adapter.getItem(i).getCode() == ID){
                                position = i;
                                break;
                            }
                        }
                    if (position < 0){
                            Toast.makeText(MainActivity.this,"Không xác định được vị trí", Toast.LENGTH_SHORT).show();
                    }else {
                            adapter.getListData().remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "Đã xóa thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        }

      //  super.onActivityResult(requestCode, resultCode, data);
    }
    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btThem){
            Intent inte = new Intent(MainActivity.this, AddpersonActivity.class);
            inte.putExtra("pos", pos++);
            startActivityForResult(inte, 10);
        }
        return super.onOptionsItemSelected(item);
    }
}
