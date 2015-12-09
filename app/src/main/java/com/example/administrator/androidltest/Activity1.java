package com.example.administrator.androidltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.Logger;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


    }

    private void stepNext(int i){

        Log.i("Activity1","stepNext当前的i的值：" + i);


    }






}
