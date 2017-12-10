package com.bridge.helloworld.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bridge.helloworld.R;

/**
 * Created by Bridge on 2017/12/10.
 */


/**
 * 自定义控件，解决每一个活动重复注册代码
 */
public class TitleLayout extends LinearLayout {

    private Button titleBack,titleEdit;
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.title,this);//为该布局再添加一个父布局，传入this
        init();
    }

    private void init() {
        //为标题栏中的按键注册点击事件
        titleBack = findViewById(R.id.title_back);
        titleEdit = findViewById(R.id.title_edit);

        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });

        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"You Clicked Edit Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
