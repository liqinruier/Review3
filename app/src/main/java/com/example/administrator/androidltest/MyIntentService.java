package com.example.administrator.androidltest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i <100 ; i++) {

            Log.i("MyService", "onStartCommand execute! i=" + i);

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==20){

                stopSelf();
            }
        }

    }


    @Override
    public void onDestroy() {
        Log.i("MyService","已经 onDestroy");
    }
}
