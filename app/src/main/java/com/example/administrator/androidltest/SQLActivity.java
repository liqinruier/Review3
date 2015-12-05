package com.example.administrator.androidltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SQLActivity extends AppCompatActivity implements View.OnClickListener{

    private Button creatsql_btn,create_btn,delete_btn,update_btn,edit_query;
    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        creatsql_btn = (Button) findViewById(R.id.creatsql_btn);
        create_btn = (Button) findViewById(R.id.create_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        update_btn = (Button) findViewById(R.id.update_btn);
        edit_query = (Button) findViewById(R.id.edit_query);

        creatsql_btn.setOnClickListener(this);
        create_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        update_btn.setOnClickListener(this);
        edit_query.setOnClickListener(this);
    }

    public class MyDatabaseHelper extends SQLiteOpenHelper{

        //建表语句
        public static final String CREATE_BOOK = "create table Book("+
                                                "id integer primary key autoincrement,"+
                                                "author text,"+
                                                "price real,"+
                                                "pages integer,"+
                                                "name test)";

        private Context mContext;
        public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_BOOK);
            Toast.makeText(mContext,"建表成功!",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.creatsql_btn:
                myDatabaseHelper = new MyDatabaseHelper(this,"book.db",null,1);
                sqLiteDatabase =  myDatabaseHelper.getWritableDatabase();

                break;
            case R.id.create_btn:

                ContentValues values = new ContentValues();
            //第一条数据
                values.put("name","你是傻逼吗");
                values.put("author","小锐");
                values.put("pages",454);
                values.put("price",163.96);
                sqLiteDatabase.insert("Book", null, values);
                values.clear();
            //第二条数据
                values.put("name","疯狂android");
                values.put("author","大大");
                values.put("pages",454);
                values.put("price",163.96);
                sqLiteDatabase.insert("Book",null,values);
                values.clear();
                //第三条
                values.put("name","疯狂java");
                values.put("author","小小");
                values.put("pages",454);
                values.put("price",163.96);
                sqLiteDatabase.insert("Book",null,values);
                values.clear();
                //这是第4条
                //增加了5


                break;
            case R.id.delete_btn:
                break;
            case R.id.update_btn:
                break;
            case R.id.edit_query:
                break;
            default:
                break;

        }
    }
}
