package com.bridge.helloworld.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

/**
 * date：2017/12/5
 * function: SecondActivity,活动间的数据来回传递，活动之间执行的操作等
 * author： Bridge
 */
public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";
    private Button button2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_second);
        /**
         * 通过intent对象获取由前一个活动传递过来的数据
         */
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d(TAG, data);
        button2 = findViewById(R.id.second_btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.putExtra("data_return","Hello FirstActivity");
//                setResult(RESULT_OK,intent);//RESULT_OK--->return -1;
//                finish();
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * function：启动活动的最佳实现方法
     * author：Bridge
     * date：2017/12/6
     * @param context 上下文环境
     * @param data1 参数1
     * @param data2 参数2
     */
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

    /**
     * 用户按返回键是执行该方法，将数据回传到上一个Activity中
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);//RESULT_OK--->return -1;
        finish();
//        super.onBackPressed();//置于该方法的第一行不会返回正确结果；删除或者放在最后一行执行得到正确的结果。why？
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
