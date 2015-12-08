package com.example.administrator.androidltest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

    private String[] data ={
            "Activity1",
            "广播发送专题",
            "点击进入百度页面",
            "点击打电话",
            "返回数据给上一级",
            "Fragment专题",
            "AsycTaskTest",
            "service专题",
            "数据存储专题",
            "SQL专题",
            "Provider专题",
            "打电话"


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mylistview);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                    startActivity(new Intent(MainActivity.this, Activity1.class));
                        //Toast.makeText(MainActivity.this,"你点击了"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:

                    startActivity(new Intent(MainActivity.this, Activity2.class));
                        //Toast.makeText(MainActivity.this,"你点击了"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.baidu.com"));
                        startActivity(intent);
                        break;
                    case 3:
                        Intent intent1 = new Intent(Intent.ACTION_DIAL);
                        intent1.setData(Uri.parse("tel:13800138000"));
                        startActivity(intent1);
                        break;
                    case 4:
                        Intent intent2 = new Intent(MainActivity.this,ActivityForResult.class);
                        startActivityForResult(intent2, 1);
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, ActivityFragment.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this,AsycTaskActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this,ActivityforService.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this,ActivityForSave.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this,SQLActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this,ActivityProvider.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this,ActivityCall.class));
                        break;
                    default:
                        break;
                }
            }
        });

    }

//用于处理
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){

            case 1:
                if(resultCode==RESULT_OK){

                    String returnData = data.getStringExtra("data_return");
                    Log.d("MainActivity",returnData);

                }



        }




    }
}
