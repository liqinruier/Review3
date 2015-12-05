package com.example.administrator.androidltest;

import android.animation.TimeAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityForSave extends AppCompatActivity implements View.OnClickListener{

    private Button savefile_btn,readfile_btn,savepreference_btn,readpreference_btn;
    private EditText edit;
    private FileOutputStream fileOutputStream = null;
    private BufferedWriter writer =null;
    private BufferedReader reader = null;
    private StringBuffer buffer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_for_save);

        savefile_btn = (Button) findViewById(R.id.savefile_btn);
        readfile_btn = (Button) findViewById(R.id.readfile_btn);
        savepreference_btn = (Button) findViewById(R.id.savepreference_btn);
        readpreference_btn = (Button) findViewById(R.id.readpreference_btn);
        edit = (EditText) findViewById(R.id.edit);

        savefile_btn.setOnClickListener(this);
        readfile_btn.setOnClickListener(this);
        savepreference_btn.setOnClickListener(this);
        readpreference_btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.savefile_btn:

                String inputContent = edit.getText().toString();
                try {

                    fileOutputStream = openFileOutput("mysavetest", Context.MODE_APPEND);

                    writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

                    writer.write(inputContent);

                    Toast.makeText(this,"写入文件成功,写入的内容为："+inputContent,Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(writer!=null){
                        try {

                            writer.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }


                break;
            case R.id.readfile_btn:

                buffer = new StringBuffer();

                try {


                  reader =  new BufferedReader(new InputStreamReader(openFileInput("mysavetest"))) ;

                    String line = "";

                    while ((line = reader.readLine())!=null){

                        buffer.append(line);

                    }


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(reader !=null){

                        try {
                            reader.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

                Toast.makeText(this,"读取的内容是："+buffer.toString(),Toast.LENGTH_SHORT).show();

                break;

            case R.id.savepreference_btn:

                SharedPreferences.Editor editor = getSharedPreferences("myprefrence", MODE_PRIVATE).edit();
                editor.putString("apple","这是一个苹果");
                editor.putString("banana","这是一个雪梨");
                editor.commit();


                break;


            case R.id.readpreference_btn:

                SharedPreferences sharedPreferences = getSharedPreferences("myprefrence",MODE_PRIVATE);
                String apple = sharedPreferences.getString("apple", "读取不到！");
                String banana = sharedPreferences.getString("banana", "读取不到！");
                String orange = sharedPreferences.getString("orange","读取不到！");


                Toast.makeText(this,"读取到的数据为："+apple+"\n"+banana+"\n"+orange,Toast.LENGTH_SHORT).show();

                break;


            default:
                break;



        }
    }
}
