package com.example.asus.otck;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OnTap_CuoiKy extends AppCompatActivity {

    Integer[] imgs = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6};

    int pathImg, position;
    ListView listView;
    TextView text;
    MyAdapter adapter, imagesAdapter;// adapter(main layout), imagesAdapter(ở Dialog)
    ArrayList<HinhAnh> listImg = new ArrayList<HinhAnh>(); //List hình ảnh main Layout
    ArrayList<HinhAnh> arr_image = new ArrayList<HinhAnh>();// List hình ảnh ở Dialog


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap__cuoi_ky);


        listView = findViewById(R.id.listView);
        text = findViewById(R.id.txtChoice);

        loadAdapter();

        registerForContextMenu(listView);
    }

    private void loadAdapter(){
        adapter = new MyAdapter(this,R.layout.custom_row, listImg);
        listView.setAdapter(adapter);
    }
///
    @Override
    public boolean onCreateOptionsMenu(Menu thisMenu) {
        getMenuInflater().inflate(R.menu.menu, thisMenu);
        return super.onCreateOptionsMenu(thisMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_Add:
                imagesAdapter = new MyAdapter(this, R.layout.custom_row_dialog, arr_image);
                Add();
                break;
            case R.id.menu_Delete:
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        position = i;
                    }
                });
                Delete();
                break;
            case R.id.menu_Edit:
                if(listImg.size() == 0){
                    Toast.makeText(getApplicationContext(),"The list is null..", Toast.LENGTH_SHORT).show();
                }else {
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            position = i;
                        }
                    });
                    editImage();
                }
                break;
        }
        return true;
    }

    //Sự kiện thêm hình ảnh
    private void Add(){
        //Dialog chứa hình ảnh
        final Dialog imgDialog = new Dialog(this);
        //Dialog chứa thông tin cần nhập
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Add new image");
        dialog.setContentView(R.layout.dialog_add);

        final Button btFind = dialog.findViewById(R.id.btFindImage);
        final Button btAdd = dialog.findViewById(R.id.btAdd);
        final EditText name = dialog.findViewById(R.id.edtName);
        final EditText size = dialog.findViewById(R.id.edtSize);
        final ImageView pic = dialog.findViewById(R.id.imgView_Dialog_Add);

        dialog.show();
        //Xử lí sự kiện nhấn nút Chọn hình ảnh(Find)
        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgDialog.setTitle("List pictures");
                imgDialog.setContentView(R.layout.list_image);

                final ListView listAllImages = imgDialog.findViewById(R.id.find_list_image);
                final Button btTake = imgDialog.findViewById(R.id.btTake);

                for(int i = 0; i < imgs.length; i++){
                    HinhAnh a = new HinhAnh(imgs[i]);
                    arr_image.add(a);
                }

                imgDialog.show();

                listAllImages.setAdapter(imagesAdapter);

                listAllImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                        pathImg = arr_image.get(i).getImgID();
                        view.setBackgroundResource(R.color.colorAccent);
                        btTake.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                pic.setImageResource(pathImg);
                                imgDialog.dismiss();
                                }
                            });
                    }
                });
            }//Kết thúc chọn hình ảnh
        });
        //Xử lí sự kiện khi nút Thêm (Add) được nhấn
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pathImg == 0){
                    Toast.makeText(getApplicationContext(),"Image is null..", Toast.LENGTH_SHORT).show();
                }else if(name.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"Name is null..", Toast.LENGTH_SHORT).show();
                }else if(size.getText().length() == 0){
                    Toast.makeText(getApplicationContext(),"Size is null..", Toast.LENGTH_SHORT).show();
                }else{
                    listImg.add(new HinhAnh(pathImg, name.getText().toString(), size.getText().toString()));
                    loadAdapter();
                    pathImg = 0; //reset lại id của hình
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Add complete..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void editImage(){
        //Dialog chứa hình ảnh
        final Dialog imgDialog = new Dialog(this);
        //Dialog chứa thông tin cần nhập
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Edit image");
        dialog.setContentView(R.layout.dialog_add);

        final Button btFind = dialog.findViewById(R.id.btFindImage);
        final Button btEdit = dialog.findViewById(R.id.btAdd);
        final EditText name = dialog.findViewById(R.id.edtName);
        final EditText size = dialog.findViewById(R.id.edtSize);
        final ImageView pic = dialog.findViewById(R.id.imgView_Dialog_Add);

        btEdit.setText("Edit"); //Sửa chữ Add thành Edit

        dialog.show();
        //Xử lí sự kiện nhấn nút Chọn hình ảnh(Find)
        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgDialog.setTitle("List pictures");
                imgDialog.setContentView(R.layout.list_image);// lấy layout cho dialog

                final ListView listAllImages = imgDialog.findViewById(R.id.find_list_image);
                final Button btTake = imgDialog.findViewById(R.id.btTake);

                // Lấy hình ảnh vào ArrayList arr_iamge
                for(int i = 0; i < imgs.length; i++){
                    HinhAnh a = new HinhAnh(imgs[i]);
                    arr_image.add(a);
                }

                imgDialog.show();

                listAllImages.setAdapter(imagesAdapter);// Đưa dữ liệu vào layout chứa danh sách hình ảnh

                listAllImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                        pathImg = arr_image.get(i).getImgID();  // lấy id của hình
                        view.setBackgroundResource(R.color.colorAccent); // background màu hồng mỗi lần click
                        btTake.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                pic.setImageResource(pathImg); //gán hình ảnh cho Dialog
                                imgDialog.dismiss();
                            }
                        });
                    }
                });
            }//Kết thúc chọn hình ảnh
        });
        //Xử lí sự kiện khi nút Thêm (Add) được nhấn
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pathImg == 0){
                    pathImg = listImg.get(position).getImgID(); //gán id hình cũ vào
                }
                if(name.getText().length() != 0){
                    listImg.get(position).setImgName(name.getText().toString()); // gán tên mới vào nếu độ dài chuỗi nhập khác 0
                }
                if(size.getText().length() != 0){
                    listImg.get(position).setImgSize(size.getText().toString());// gán size mới vào nếu độ dài chuỗi nhập khác 0
                }
                listImg.get(position).setImgID(pathImg); // gán hình mới(hoặc cũ) vào

                loadAdapter(); // load lại dữ liệu

                pathImg = 0; //reset lại id của hình

                dialog.dismiss(); // đóng dialog

                Toast.makeText(getApplicationContext(), "Edit complete..", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //Xóa hình(Delete)
    private void Delete(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete image")
                .setIcon(R.drawable.ic_delete)
                .setMessage("Delete this image ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(listImg.size() == 0){
                            Toast.makeText(getApplicationContext(),"The list is null..", Toast.LENGTH_SHORT).show();
                        }else {
                            listImg.remove(position);
                            loadAdapter();
                            Toast.makeText(getApplicationContext(), "Delete complete..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        builder.show();
    }

    //Tạo menu khi nhấn giữ một item trong listView
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.longtime_onclick, menu);
    }

    //Xử lý sự kiện nhấn đè 1 item trong listView
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Lấy thông tin về Context (view, item được chọn)
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        position = info.position;
        int id = item.getItemId();
        switch (id){
            case R.id.itemDelete:
                Delete();
                break;
            case R.id.itemEdit:
                editImage();
                break;
        }
        return true;
    }
}
