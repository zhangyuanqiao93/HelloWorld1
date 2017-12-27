package com.bridge.helloworld;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bridge.helloworld.activity.BroadcastActivity;
import com.bridge.helloworld.activity.FirstActivity;
import com.bridge.helloworld.activity.FragmentActivity;
import com.bridge.helloworld.activity.HelloActivity;
import com.bridge.helloworld.activity.ListViewActivity;
import com.bridge.helloworld.activity.MsgActivity;
import com.bridge.helloworld.activity.RecycleActivity;
import com.bridge.helloworld.activity.UIWidgetActivity;
import com.bridge.helloworld.util.BaseActivity;

import java.sql.BatchUpdateException;


/**
 * date：2017/12/5
 * function: MainActivity，主活动
 * author： Bridge
 */
public class MainActivity extends BaseActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9;

    private Button forceOffLine;
    private Button save_data;
    private Button get_data;

    private static final String TAG = "MainActivity";//快捷键:logt + tab or enter
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//给当前的活动引入一个布局

//        隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        Log.e("HelloWorldActivity", "onCreate: onCreate execute");//调试信息，debug级别日志
        init();
    }



    private void init() {
        Log.wtf(TAG, "init" );//在输出日志的同时，会把此处代码此时的执行路径(调用栈)打印出来
        Log.e("data", "onCreate: onCreate execute");//调试信息，debug级别日志
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.UI_widget);
        button5 = findViewById(R.id.list_view01);
        button6 = findViewById(R.id.recycler_view);
        button7 = findViewById(R.id.msg_recycler_view);
        button8 = findViewById(R.id.fragment_activity);//启动FragmentActivity
        button9 = findViewById(R.id.broadcast_activity);//启动BroadcastActivity
        forceOffLine = findViewById(R.id.force_offline);//强制下线
        save_data = findViewById(R.id.save_data);//存储数据
        get_data = findViewById(R.id.get_data);//获取SharedPreferences.Editor对象存储的数据
        get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences editor = getSharedPreferences("data",MODE_PRIVATE);
                String name = editor.getString("name",null);
                Integer age = editor.getInt("age",0);
                Boolean isHouse = editor.getBoolean("isHouse",true);

                Log.d(TAG, "name: "+ name);
                Log.d(TAG, "age:  "+ age);
                Log.d(TAG, "isHouse:  "+ isHouse);

            }
        });
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 开始存储数据，请稍后");
                //1.获取SharedPreferences.Editor对象
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();

                //2.添加数据
                editor.putString("name","Bridge");
                editor.putInt("age",20);
                editor.putBoolean("isHouse",true);

                //editor.commit();
                //3.提交数据
                editor.apply();
                Log.d(TAG, "onClick: 保存数据成功！");
            }
        });

        forceOffLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //强制下线
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: BroadcatActivity");
                Intent intent = new Intent(MainActivity.this,BroadcastActivity.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: FragmentActivity");
                Intent intent = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ListViewActivity");
                Intent intent = new Intent(MainActivity.this,MsgActivity.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ListViewActivity");
                Intent intent = new Intent(MainActivity.this,RecycleActivity.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ListViewActivity");
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UIWidgetActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: HelloActivity");
                Intent intent = new Intent(MainActivity.this,HelloActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点我点我！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked Me！",Toast.LENGTH_SHORT).show();
                //finish();//销毁一个活动
            }
        });
    }


    /**
     * 不可见变为可见时调用onStart();
     */
    @Override
    protected void onStart() {
        super.onStart();

    }

    /**
     * 在活动完全不可见的时候调用
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 该方法在活动准备和用户进行交互的时候调用，此时活动一定位于栈顶，并且处于运行状态
     */
    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * 系统准备启动或者恢复另一个活动的时候调用
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 活动被销毁之前调用
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 由停止转变为运行状态
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
