package com.bridge.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * date：2017/12/5
 * function: MainActivity，主活动
 * author： Bridge
 */
public class MainActivity extends AppCompatActivity {
    private Button button1,button2;

    private static final String TAG = "MainActivity";//快捷键:logt + tab or enter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//给当前的活动引入一个布局
        Log.d("HelloWorldActivity", "onCreate: onCreate execute");//调试信息，debug级别日志
        init();
    }

    private void init() {
        //Log.d("data", "onCreate: onCreate execute");//调试信息，debug级别日志
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
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
}
