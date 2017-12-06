package com.bridge.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloActivity extends AppCompatActivity {
    private static final String TAG = "HelloActivity";
    private Button normal_btn,dialog_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate:1----error ");
        Log.d(TAG, "onCreate:1----debug ");
        Log.v(TAG, "onCreate:1----verbose ");
        //Toast.makeText(HelloActivity.this, "onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_hello);

        /**********----------获取活动被回收之前的数据start----------**************/
        if (savedInstanceState != null){
            String tempData = savedInstanceState.getString("tempData");
            Log.d(TAG, "onCreate: " + tempData);
        }
        /**********----------获取活动被回收之前的数据end----------**************/

        init();
    }

    private void init() {
        normal_btn = findViewById(R.id.start_normal_act);
        dialog_btn = findViewById(R.id.start_dialog_act);

        normal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart:2");
        //Toast.makeText(HelloActivity.this, "onStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume:3 ");
        //Toast.makeText(HelloActivity.this, "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause:4");
        //Toast.makeText(HelloActivity.this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop:5");
        //Toast.makeText(HelloActivity.this, "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy:6");
        //Toast.makeText(HelloActivity.this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart:7");
        //Toast.makeText(HelloActivity.this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    /**
     * 用于保存临时数据的回调函数，在活动被回收之前一定会执行
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String tempData = "Something you just typed";
        outState.putString("temp_data",tempData);

    }
}
