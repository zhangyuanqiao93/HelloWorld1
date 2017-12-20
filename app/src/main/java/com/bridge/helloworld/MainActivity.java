package com.bridge.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bridge.helloworld.util.BaseActivity;


/**
 * date：2017/12/5
 * function: MainActivity，主活动
 * author： Bridge
 */
public class MainActivity extends BaseActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8;

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
