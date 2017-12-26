package com.bridge.helloworld.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bridge.helloworld.MainActivity;
import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

public class Login2Activity extends BaseActivity {

    private EditText accountEditText,passwordEditText;//定义文本框，用户名和密码输入框
    private Button login;//定义登录按钮
    private static final String TAG = "Login2Activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Log.d(TAG, "onCreate: 进入Login2Activity");
        initView();
    }

    /**
     * 初始化组件登录按钮和可编辑的EditText输入框
     */
    private void initView() {
        Log.d(TAG, "initView: 开始初始化组件");

        login = findViewById(R.id.login);
        accountEditText = findViewById(R.id.account2);
        passwordEditText = findViewById(R.id.password2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本框的输入内容，用户名和密码
                String account = accountEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                //如果账号admin,密码123456表示登录成功

                /**
                 * 数据应该动态从数据库读取，此处模拟数据
                 */
                if (account.equals("admin") && password.equals("123456")){
                    Log.e(TAG, "onClick: 登录成功!");
                    Log.e(TAG, "onClick: -->打印输入的账号: " + account );
                    Log.e(TAG, "onClick: -->打印输入的密码: " + password );
                    Intent intent = new Intent(Login2Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();//回到登录界面活动时，结束所有的活动。
                }else {
                    Log.e(TAG, "onClick: 登录失败，请重新登录!");
                    Toast.makeText(Login2Activity.this,"account or password id not invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
