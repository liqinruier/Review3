package com.example.administrator.androidltest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private Button button,button2;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.xiaorui.receiver");
                sendBroadcast(intent);

            }
        });

        //button2的监听事件
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.xiaorui.localbroadcast");
                localBroadcastManager.sendBroadcast(intent);


            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaorui.localbroadcast");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

    }


    @Override
    protected void onDestroy() {

        localBroadcastManager.unregisterReceiver(localReceiver);

        super.onDestroy();
    }


    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context,"接收到了本地广播!",Toast.LENGTH_SHORT).show();
        }
    }

}
