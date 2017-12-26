package com.bridge.helloworld.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bridge.helloworld.R;
import com.bridge.helloworld.fragment.AnotherRightFragment;
import com.bridge.helloworld.fragment.RightFragment;
import com.bridge.helloworld.util.BaseActivity;

public class FragmentActivity extends BaseActivity {

    private static final String TAG = "FragmentActivity";
    private Button fragment_btn;//点击按钮跳转到FragmentActivity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        init();

        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment fragment) {//此处应该有问题

        //2.获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();//获取FragmentManager

        //3.开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启事务

        //4.想容器添加或者替换碎片
        FragmentTransaction replace = transaction.replace(R.id.right_layout_fragment, fragment);//暂时不用提交

        //6.将事务添加到返回栈中
        transaction.addToBackStack(null);

        //5.提交事务
        transaction.commit();//提交事务
    }

    private void init() {
        Log.d(TAG, "init: 初始化FragmentActivity数据");

        /**
         *
         * ***************************************
         * 碎片和活动之间的通信测试代码start
         * ***************************************
         */

        //RightFragment fragment = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.right_layout_fragment);
        //FragmentActivity activity = (FragmentActivity) getActivity();
        /**
         *
         * ***************************************
         * 碎片和活动之间的通信测试代码end
         * ***************************************
         */
        //1.创建待添加碎片的实例
        fragment_btn = findViewById(R.id.fragment_btn);
        fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FragmentActivity.this,TAG+" :点击Fragment按钮",Toast.LENGTH_SHORT).show();

                switch (v.getId()){
                    case R.id.fragment_btn ://左侧Fragment的按钮id
                        Log.d(TAG, "onClick: " + R.id.fragment_btn);
                        replaceFragment(new AnotherRightFragment());
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
