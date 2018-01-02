package com.bridge.helloworld.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bridge.helloworld.R;
import com.bridge.helloworld.database.MyDatabaseHelper;

import org.litepal.tablemanager.Connector;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "DatabaseActivity";

    private MyDatabaseHelper myDatabaseHelper;
    private Button add_data,update_data,delete_data,query_data,create_data;
    private ContentValues contentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        init();
        Log.d(TAG, "onCreate: 开始创建数据库");

    }

    private void init() {
        add_data = findViewById(R.id.add_data);
        add_data.setOnClickListener(this);

        update_data = findViewById(R.id.update_data);
        update_data.setOnClickListener(this);

        delete_data = findViewById(R.id.delete_data);
        delete_data.setOnClickListener(this);

        query_data =findViewById(R.id.query_data);
        query_data.setOnClickListener(this);

        create_data = findViewById(R.id.create_db);
        create_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        SQLiteDatabase writableDatabase = myDatabaseHelper.getWritableDatabase();
        contentValues = new ContentValues();

        switch (v.getId()){
            case R.id.add_data:
                //执行逻辑操作
                Log.d(TAG, "onClick: add_data");
                contentValues.put("name","Bridge");
                Log.d(TAG, "onClick: " + contentValues.get("name"));
                contentValues.put("author","Bridge");
                Log.d(TAG, "onClick: " + contentValues.get("author"));
                contentValues.put("pages",213);
                Log.d(TAG, "onClick: " + contentValues.get("pages"));
                contentValues.put("price",28.88);
                Log.d(TAG, "onClick: " + contentValues.get("price"));

                //插入第一条数据
                writableDatabase.insert("Book",null,contentValues);

                contentValues.clear();

                //插入第二条数据
                contentValues.put("name","George");
                Log.d(TAG, "onClick: " + contentValues.get("name"));
                contentValues.put("author","George");
                Log.d(TAG, "onClick: " + contentValues.get("author"));
                contentValues.put("pages",222);
                Log.d(TAG, "onClick: " + contentValues.get("pages"));
                contentValues.put("price",39.99);
                Log.d(TAG, "onClick: " + contentValues.get("price"));
                break;

            case R.id.update_data:
                Log.d(TAG, "onClick: update_data");
                contentValues.put("price",9.9);
                Log.d(TAG, "onClick: " + contentValues.get("price"));
                writableDatabase.update("Book",contentValues,"name = ?",new String[] {"Bridge"});
                Log.d(TAG, "onClick: 数据表更新成功！");
                break;

            case R.id.delete_data:
                Log.d(TAG, "onClick: delete_data");
                //删除了一整条记录
                writableDatabase.delete("Book","pages > ?",new String[]{ "221"});
                Log.d(TAG, "onClick: " + contentValues.get("pages"));
                Log.d(TAG, "onClick: " + contentValues.get("name"));
                Log.d(TAG, "onClick: " + contentValues.get("author"));
                break;

            case R.id.query_data:
                Cursor cursor;
                cursor = writableDatabase.query(false,"Book",null,null,null,null,null,null,null);

                if (cursor.moveToFirst()){

                    do {
                        //遍历取出打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));

                        Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Integer pages = cursor.getInt(cursor.getColumnIndex("pages"));

                        Log.d(TAG, "Book name is: "+ name);
                        Log.d(TAG, "Book price is: "+ price);
                        Log.d(TAG, "Book author is: "+ author);
                        Log.d(TAG, "Book pages is: "+ pages);

                    }while (cursor.moveToNext());

                }

                cursor.close();
                break;

            case R.id.create_db:
                //Connector.getDatabase();
                Log.d(TAG, "onClick:   Connector.getDatabase()--->Litepal");
                break;
            default:
                break;
        }
    }
}
