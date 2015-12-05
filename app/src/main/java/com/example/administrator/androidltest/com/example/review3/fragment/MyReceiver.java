package com.example.administrator.androidltest.com.example.review3.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"接收到了xiaorui广播!",Toast.LENGTH_SHORT).show();

    }
}
