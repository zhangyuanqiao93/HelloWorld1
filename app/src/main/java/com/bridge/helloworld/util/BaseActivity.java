package com.bridge.helloworld.util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bridge.helloworld.controller.ActivityController;

/**
 * Created by Bridge on 2017/12/6.
 */

public  class  BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());

        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
