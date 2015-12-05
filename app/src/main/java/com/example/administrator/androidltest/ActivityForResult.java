package com.example.administrator.androidltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityForResult extends AppCompatActivity {


    private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_for_result);

        button = (Button) findViewById(R.id.mybtn);
        button2 = (Button) findViewById(R.id.mybtn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.putExtra("data_return","You are a Bitch!");
                setResult(RESULT_OK, intent);
                finish();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForResult.this,DialogActivity.class));

            }
        });

    }
}
