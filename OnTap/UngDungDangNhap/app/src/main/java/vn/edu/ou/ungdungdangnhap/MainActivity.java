package vn.edu.ou.ungdungdangnhap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btLogin;
    EditText editText;
    TextView view;
    Class aClass;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin =(Button)findViewById(R.id.ID_btLogin);
        editText = (EditText)findViewById(R.id.editName);
        view = (TextView)findViewById(R.id.textView);

       editText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               //Toast.makeText(MainActivity.this,"before",Toast.LENGTH_SHORT).show();
           }
           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               //Toast.makeText(MainActivity.this,"start",Toast.LENGTH_SHORT).show();
               if(s.length() == 0){
                   view.setText("Login Screen");
               }
               else{
                   view.setText("Wait");
               }
           }
           @Override
           public void afterTextChanged(Editable s) {
               //Toast.makeText(MainActivity.this,"finish",Toast.LENGTH_SHORT).show();
           }
       });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Chào ngày mới: " + editText.getText().toString()
                ,Toast.LENGTH_LONG).show();
                /*Cách 1:
                Intent intent = new Intent(v.getContext(),secondActivity.class);
                startActivityForResult(intent,0);
                * */
                //Cách 2:Mở activity mới
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        /*
        btLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                }
                else{
                }
            }
        });
*/
    }
}
