package com.bridge.helloworld.activity;

import android.os.Bundle;

import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

/**
 * 对话框式活动
 */
public class DialogActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}
