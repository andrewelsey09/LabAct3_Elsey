package com.elsey.labno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etSchool1,etSchool2,etSchool3,etSchool4,etSchool5,etSchool6,etSchool7,etSchool8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etSchool1 = findViewById(R.id.school1);
        etSchool2 = findViewById(R.id.school2);
        etSchool3 = findViewById(R.id.school3);
        etSchool4 = findViewById(R.id.school4);
        etSchool5 = findViewById(R.id.school5);
        etSchool6 = findViewById(R.id.school6);
        etSchool7 = findViewById(R.id.school7);
        etSchool8 = findViewById(R.id.school8);

    }

    public void save(View v) {

        String data1 = etSchool1.getText().toString()+ ",";
        String data2 = etSchool2.getText().toString()+ ",";
        String data3 = etSchool3.getText().toString()+ ",";
        String data4 = etSchool4.getText().toString()+ ",";
        String data5 = etSchool5.getText().toString()+ ",";
        String data6 = etSchool6.getText().toString()+ ",";
        String data7 = etSchool7.getText().toString()+ ",";
        String data8 = etSchool8.getText().toString()+ ",";

        FileOutputStream writer = null;

        try{
            writer = openFileOutput("data1.txt",MODE_PRIVATE);
            writer.write(data1.getBytes());
            writer.write(data2.getBytes());
            writer.write(data3.getBytes());
            writer.write(data4.getBytes());
            writer.write(data5.getBytes());
            writer.write(data6.getBytes());
            writer.write(data7.getBytes());
            writer.write(data8.getBytes());

        } catch (FileNotFoundException e){
            Log.d("error","file not found");
        } catch (IOException e){
            Log.d("error","IO Error");
        } finally{
            try {
                writer.close();
            } catch (IOException e){
                Log.d("error","IO error");
            }
        }
    }

    public void next(View v){
        Intent intent = new Intent(this, ButtonList.class);
        startActivity(intent);
    }
}
