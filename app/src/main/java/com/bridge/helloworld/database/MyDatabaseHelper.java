package com.bridge.helloworld.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Bridge on 2017/12/28.
 *
 */

/**
 * SQLite数据库实例
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;

    private static final String TAG = "MyDatabaseHelper";
    private static final String CREATE_BOOK = "create table Book ("
            + "id Integer primary key  autoincrement," +
            "price real," +
            "author text," +
            "name text," +
            "pages integer)";

    private static final String CREATE_CATEGORY = "create table Category ("
            + "id Integer primary key  autoincrement," +
            "category_name text," +
            "category_code integer)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    //重写两个方法1
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);//创建一个数据表CREATE_BOOK
        db.execSQL(CREATE_CATEGORY);//创建一个数据表CREATE_CATEGORY
        Log.d(TAG, "onCreate: " + CREATE_BOOK + "----create succeeded-----");
        Toast.makeText(mContext,"Create Succeeded",Toast.LENGTH_SHORT).show();
    }


    //重写两个方法2
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新数据库逻辑操作
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //super.onDowngrade(db, oldVersion, newVersion);
        Log.d(TAG, "onDowngrade: " + db.getVersion());
    }
}
