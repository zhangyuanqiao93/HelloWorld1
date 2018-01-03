package com.bridge.helloworld.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bridge.helloworld.R;

/**
 * 内容提供器，用于应用间的数据共享
 */

public class ProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);


    }
}
