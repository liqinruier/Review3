package com.example.administrator.androidltest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AsycTaskActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Button button;
    private TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyc_task);

        progressDialog = new ProgressDialog(this);
        button = (Button) findViewById(R.id.asy_btn);
        textView = (TextView) findViewById(R.id.asy_tv);
        textView1 = (TextView) findViewById(R.id.asy_tv1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownLoadTask().execute();
            }
        });


    }

//下载任务类
    class DownLoadTask extends AsyncTask<Void,Integer,Integer>{


        @Override
        protected Integer doInBackground(Void... params) {

            int i;
            for ( i = 0; i <101; i++) {

                try {

                    publishProgress(i);
                    Thread.sleep(500);

                   /* if(i==100){
                        progressDialog.cancel();

                    }*/
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return i;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

           /* progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("进度更新中...");
            progressDialog.setCancelable(false);
            progressDialog.show();*/

            textView1.setText("更新中的i的值为："+values[0]);

        }

        @Override
        protected void onPostExecute(Integer aInteger) {

            textView.setText(aInteger.toString());
        }


    }

}
