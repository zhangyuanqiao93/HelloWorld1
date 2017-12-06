package com.bridge.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bridge.helloworld.controller.ActivityController;
import com.bridge.helloworld.util.BaseActivity;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";
    private Button button3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is : " + getTaskId());
        setContentView(R.layout.activity_third);
        init();
    }

    private void init() {
        button3 = findViewById(R.id.third_act_btn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //结束所有的活动，退出程序
                ActivityController.finishAll();
            }
        });
    }
}
