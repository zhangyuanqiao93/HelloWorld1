package com.bridge.helloworld.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bridge.helloworld.MainActivity;
import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

public class Login2Activity extends BaseActivity {

    private EditText accountEditText,passwordEditText;
    private Button login;
    private static final String TAG = "Login2Activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        login = findViewById(R.id.login);
        accountEditText = findViewById(R.id.account2);
        passwordEditText = findViewById(R.id.password2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                //如果账号admin,密码123456表示登录成功

                if (account.equals("admin") && password.equals("123456")){

                    Intent intent = new Intent(Login2Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Log.d(TAG, "onClick: 登录失败，请重新登录!");
                    Toast.makeText(Login2Activity.this,"account or password id not invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
