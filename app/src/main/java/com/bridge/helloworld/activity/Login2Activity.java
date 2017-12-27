package com.bridge.helloworld.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bridge.helloworld.MainActivity;
import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

public class Login2Activity extends BaseActivity {

    private EditText accountEditText,passwordEditText;//定义文本框，用户名和密码输入框
    private Button login;//定义登录按钮
    private static final String TAG = "Login2Activity";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

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

        rememberPass = findViewById(R.id.remember_pass);//记住密码

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = sharedPreferences.getBoolean("remember_password",false);
        if (isRemember){
            //将账号和密码都设置到文本框中
            String account = sharedPreferences.getString("account","");
            String password = sharedPreferences.getString("password","");

            accountEditText.setText(account);//将存储的用户名输入到账户名输入框
            passwordEditText.setText(password);//将存储的密码设置到密码框
            rememberPass.setChecked(true);//是否可以选择

        }

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

                    editor = sharedPreferences.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String account = accountEditText.getText().toString().trim();//获取用户名
        String password = passwordEditText.getText().toString().trim();//获取密码
        Log.d(TAG, "onDestroy: "+ account);
        Log.d(TAG, "onDestroy: "+ password);

        //DataUtil.save(account);//save()方法会报错空指针异常。
        //DataUtil.save(password);

    }
}
