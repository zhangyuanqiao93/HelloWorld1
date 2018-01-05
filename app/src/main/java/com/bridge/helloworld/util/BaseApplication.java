package com.bridge.helloworld.util;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bridge.helloworld.entity.DaoMaster;
import com.bridge.helloworld.entity.DaoSession;



/**
 * Created by Bridge on 2018/1/3.
 * GreenDao创建数据库
 */

public class BaseApplication extends Application {

   private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     * return
     */
    private void setupDatabase() {

        //创建数据库shop.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"shop.db",null);

        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();

        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);

        //获取数据库对象管理者
        daoSession = daoMaster.newSession();


    }

    public static DaoSession getDaoInstant(){
        return daoSession;
    }
}
