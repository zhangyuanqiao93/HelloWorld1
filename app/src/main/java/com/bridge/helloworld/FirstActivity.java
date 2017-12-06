package com.bridge.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.Toast;

import com.bridge.helloworld.util.BaseActivity;

/**
 * date：2017/12/5
 * function: FirstActivity,活动间的数据来回传递，活动之间执行的操作等
 * author： Bridge
 */
public class FirstActivity extends BaseActivity {//继承自AppCompatActivity，实现更好的兼容性质

    private static final String TAG = "FirstActivity";
    private Button first_btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
//        常用来在加载布局或者是绑定事件的时候使用。
        super.onCreate(savedInstanceState);
//        Log.d(TAG, this.toString());//活动的启动模式
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_first);
        init();

    }

    private void init() {
        first_btn = findViewById(R.id.first_btn);
        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"再点我试试!",Toast.LENGTH_SHORT).show();
                //String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);//携带请求码，要求是唯一值
                //intent.putExtra("extra_data",data);//通过键值对的方式传递数据;
//                intent.setData(Uri.parse("tel:10000"));
                //intent.addCategory("android.intent.action.MY_ANSWER");
                //startActivity(intent);//启动活动
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
    }

    /**
     * 重写onCreateOptionsMenu()
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * 定义菜单相应事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 重新onActivityResult()回调函数来接收回传回来的参数
     * @param requestCode 启动活动时传入的请求码
     * @param resultCode 返回数据时传入的处理结果
     * @param data 携带着返回数据的Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                    Toast.makeText(FirstActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
