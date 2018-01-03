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
import com.bridge.helloworld.dao.LoveDao;
import com.bridge.helloworld.database.MyDatabaseHelper;
import com.bridge.helloworld.entity.Book;
import com.bridge.helloworld.entity.DaoSession;
import com.bridge.helloworld.entity.Shop;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "DatabaseActivity";
    private static int i = 10;

    private MyDatabaseHelper myDatabaseHelper;
    private Button add_data,update_data,delete_data,query_data,create_data;
    private ContentValues contentValues;
    private Button litepal_add_data,greendao_add_data;


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

        litepal_add_data = findViewById(R.id.litepal_add_data);
        litepal_add_data.setOnClickListener(this);


        greendao_add_data = findViewById(R.id.greendao_add_data);
        greendao_add_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
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
                Log.d(TAG, "onClick:   Connector.getDatabase()--->Litepal 1");
                writableDatabase.execSQL("drop table if exists Book");
                writableDatabase.execSQL("drop table if exists Category");
                Connector.getDatabase();
                Log.d(TAG, "onClick:   Connector.getDatabase()--->Litepal 2");

                Log.d(TAG, "pages: " + contentValues.get("pages"));
                Log.d(TAG, "name: " + contentValues.get("name"));
                Log.d(TAG, "author: " + contentValues.get("author"));
                break;

            case R.id.litepal_add_data:
                Log.d(TAG, "litepal add data.");
                Book book = new Book();
                book.setName("Android 第一行代码");
                book.setAuthor("郭霖");
                book.setPrice(39.9);
                book.setPress("清华大学出版社");

                book.save();//保存数据
                Log.d(TAG, "****保存数据成功****");

                List<Book> books = DataSupport.findAll(Book.class);
                for (Book mybook: books){
                    Log.d(TAG, "Name: " + mybook.getName());
                    Log.d(TAG, "Author: " + mybook.getAuthor());
                    Log.d(TAG, "Pages: " + mybook.getPages());
                    Log.d(TAG, "Price: " + mybook.getPrice());
                    Log.d(TAG, "Id: " + mybook.getId());
                }
                break;

            case R.id.greendao_add_data:

                Shop shop = new Shop();
                shop.setType(Shop.TYPE_LOVE);
                shop.setAddress("四川成都");
                shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
                shop.setPrice("29.88");
                shop.setSell_num(180103);
                shop.setName("正宗梅菜扣肉 聪厨梅" + "干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i ++);


//                LoveDao.insertLove(shop);//空指针异常，why

                Log.d(TAG, "Type is : "+ shop.getType());
                Log.d(TAG, "Address is : "+ shop.getAddress());
                Log.d(TAG, "Price is : "+ shop.getPrice());
                Log.d(TAG, "Name is : "+ shop.getName());

                break;

            default:
                break;
        }
    }
}
