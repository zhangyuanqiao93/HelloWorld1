package com.bridge.helloworld.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容提供器，用于应用间的数据共享
 */

public class ProviderActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "ProviderActivity";
    private Button make_call;
    private ListView contact_view;
    ArrayAdapter<String> adapter;
    List<String> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        init();
    }

    private void init() {
        Log.d(TAG, "init: 初始化Make Call 按钮!");
        make_call = findViewById(R.id.make_call);
        make_call.setOnClickListener(this);

        contact_view = findViewById(R.id.contact_view);
        Log.d(TAG, "init: 初始化listview完成");
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        contact_view.setAdapter(adapter);
        Log.d(TAG, "init: 开始获取联系人");
        //获取联系人
        getContacts();

    }

    private void getContacts() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            Log.d(TAG, "makeCall: 获得动态权限查看手机联系人");
            ActivityCompat.requestPermissions(ProviderActivity.this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else {
            readContact();
        }
    }

    private void readContact() {
        Log.d(TAG, "readContact: 获取联系人中。。。");
        Cursor cursor = null;
        try{
             cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null
                    ,null,null,null);
            if (cursor != null){
                while (cursor.moveToNext()){

                    //获取联系人姓名
                    String display = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    Log.d(TAG, "readContact: "+ display);
                    //获取联系人电话号码
                    String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Log.d(TAG, "readContact: "+ phone);
                    list.add(display + "\n" + phone);
                }
                //TODO
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            if (cursor != null) {
                cursor.close();
                Log.d(TAG, "readContact: 关闭cursor");
            }
        }

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.make_call:
                //添加逻辑操作
                makeCall();
                break;

            default:
                break;
        }
    }

    /**
     * 拨打电话操作
     */
    private void makeCall() {
        Log.d(TAG, "makeCall: 拨打电话中...");
        
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);//拨打电话
            intent.setData(Uri.parse("tel:10000"));
            Log.d(TAG, "makeCall: " + Uri.decode("10000"));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                Log.d(TAG, "makeCall: 获得动态权限拨打电话");
                ActivityCompat.requestPermissions(ProviderActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                
            }else {
                startActivity(intent);
            }
           
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 用户权限回调函数
     * @param requestCode 请求码
     * @param permissions 权限
     * @param grantResults 返回码
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult: 进入权限回调函数");
        switch (requestCode){
            case 1:
                if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //makeCall();
                    readContact();
                }else {
                    Log.d(TAG, "onRequestPermissionsResult: 权限不允许，退出。");
                    Toast.makeText(ProviderActivity.this,"You denied the permission!",Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                //break;

        }

    }
}
