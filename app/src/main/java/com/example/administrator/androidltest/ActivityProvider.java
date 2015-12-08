package com.example.administrator.androidltest;

import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityProvider extends AppCompatActivity {

    private ListView contactView;
    private ArrayAdapter<String> adapter;
    private List<String> contentlist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_provider);

        contactView = (ListView) findViewById(R.id.contact_list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contentlist);

        contactView.setAdapter(adapter);
        readContacts();

    }

    private void readContacts(){

        Cursor cursor = null;

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        while (cursor.moveToNext()){

           String displayName =  cursor.getString(cursor.getColumnIndex(
                   ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER));

            contentlist.add(displayName +"\n"+number);


        }

        if(Build.VERSION.SDK_INT < 14){

            cursor.close();
        }
    }



}
