package com.bridge.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bridge.helloworld.util.BaseActivity;

/**
 *普通的活动
 */
public class NormalActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }
}
