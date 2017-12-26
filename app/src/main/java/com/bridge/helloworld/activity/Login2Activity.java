package com.bridge.helloworld.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

public class Login2Activity extends BaseActivity {

    private EditText accountEditText,passwordEditText;
    private Button login;

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
            }
        });
    }
}
