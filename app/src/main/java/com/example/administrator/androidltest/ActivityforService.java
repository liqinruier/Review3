package com.example.administrator.androidltest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ActivityforService extends AppCompatActivity implements View.OnClickListener{

    private Button startservice_btn,stopservice_btn,
                     bindservice_btn,unbindservice_btn,
            startintentservice_btn,stopintentservice_btn
            ;

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();


            Toast.makeText(ActivityforService.this,"connection已经执行！",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityfor_service);
        startservice_btn = (Button) findViewById(R.id.startservice_btn);
        stopservice_btn = (Button) findViewById(R.id.stopservice_btn);
        bindservice_btn = (Button) findViewById(R.id.bindservice_btn);
        unbindservice_btn = (Button) findViewById(R.id.unbindservice_btn);
        startintentservice_btn = (Button) findViewById(R.id.startintentservice_btn);
        stopintentservice_btn = (Button) findViewById(R.id.stopintentservice_btn);

        startservice_btn.setOnClickListener(this);
        stopservice_btn.setOnClickListener(this);
        bindservice_btn.setOnClickListener(this);
        unbindservice_btn.setOnClickListener(this);
        startintentservice_btn.setOnClickListener(this);
        stopintentservice_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //开启服务按钮
            case R.id.startservice_btn:
                Toast.makeText(this,"点击了开始按钮！",Toast.LENGTH_SHORT).show();
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            //关闭服务按钮
            case R.id.stopservice_btn:
                Toast.makeText(this,"点击了停止按钮！",Toast.LENGTH_SHORT).show();
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            //绑定服务按钮
            case R.id.bindservice_btn:

                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);

                break;
            //取消绑定服务按钮
            case R.id.unbindservice_btn:

                unbindService(connection);

                break;
            //开启IntentService
            case R.id.startintentservice_btn:

                startService(new Intent(this,MyIntentService.class));

                break;
            //停止IntentService
            case R.id.stopintentservice_btn:

                stopService(new Intent(this,MyIntentService.class));

                break;
            default:
                break;

        }
    }
}
