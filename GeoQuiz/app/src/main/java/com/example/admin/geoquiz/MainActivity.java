package com.example.admin.geoquiz;
// Chưa làm thêm trường hợp nhiều câu hỏi
// Thêm 2 nút pre và Next
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btTrue, btFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btFalse = (Button) findViewById(R.id.btFalse);
        btTrue = (Button) findViewById(R.id.btTrue);

        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.Correct,Toast.LENGTH_SHORT).show();
            }
        });
        btTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.InCorrect,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
