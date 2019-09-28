package com.elsey.labno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ButtonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_list);

        FileInputStream reader = null;
        String msg="";
        try {
            int token;
            StringBuffer buffer = new StringBuffer();
            reader = openFileInput("data1.txt");
            while ((token=reader.read())!=-1){
                buffer.append((char)token);
                msg=msg+(char)token;
            }
            reader.close();
            try {
                String list[] = msg.split(",");
                ((Button) (findViewById(R.id.button4))).setText(list[0]);
                ((Button) (findViewById(R.id.button5))).setText(list[1]);
                ((Button) (findViewById(R.id.button6))).setText(list[2]);
                ((Button) (findViewById(R.id.button7))).setText(list[3]);
                ((Button) (findViewById(R.id.button8))).setText(list[4]);
                ((Button) (findViewById(R.id.button9))).setText(list[5]);
                ((Button) (findViewById(R.id.button10))).setText(list[6]);
                ((Button) (findViewById(R.id.button11))).setText(list[7]);
            } catch (Exception e){

            }

        } catch (FileNotFoundException e){
            Log.d("error", "file not found error");
        } catch (IOException e) {
            Log.d("error","file is empty");
        }
    }

    public void prevois(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
