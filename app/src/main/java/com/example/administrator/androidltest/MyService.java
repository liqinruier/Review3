package com.example.administrator.androidltest;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    int i =0;
    private DownloadBinder mBinder = new DownloadBinder();

     class DownloadBinder extends Binder{

        public void startDownload(){

            Log.i("MyService", "startDownload");
        }
        public int getProgress(){

            Log.i("MyService", "getProgress");

            return 0;
        }



    }


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    @Override
    public void onCreate() {




/*      前台服务部分
        Notification notification = NotificationCompat.Builder(getBaseContext());
        Intent notificationIntent = new Intent(this,ActivityforService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        notification.

        startForeground(1, notification);*/

        Log.i("MyService", "onCreate execute");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService", "onStartCommand execute");

       /* for (int i = 0; i <100 ; i++) {

            Log.i("MyService","onStartCommand execute! i="+i);

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==20){

                stopSelf();
            }
        }*/

      /*  Log.i("MyService","onStartCommand execute! i="+i);
        i++;*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {

                    Log.i("MyService","onStartCommand execute! i="+i);

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
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.i("MyService","onDestroy execute");
        super.onDestroy();
    }
}
