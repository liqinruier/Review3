package com.example.administrator.androidltest.com.example.review3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.administrator.review3.IMyAidlInterface;

import java.util.Timer;
import java.util.TimerTask;

public class AIDLService extends Service {

    private CatBinder catBinder;
    Timer timer = new Timer();
    private String color;
    private double weight;

    String[] colors = new String[]{
      "红色","黄色","黑色"

    };

    double[] weights = new double[]{
        2.3,3.1,1.58

    };

    public class CatBinder extends IMyAidlInterface.Stub{

        @Override
        public String getColor() throws RemoteException {
            return color;
        }

        @Override
        public double getWeight() throws RemoteException {
            return weight;
        }
    }


    public AIDLService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        catBinder = new CatBinder();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int rand = (int) (Math.random() * 3);
                color = colors[rand];
                weight = weights[rand];
                System.out.print("-----------"+rand);

            }
        },0,800);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return catBinder;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
