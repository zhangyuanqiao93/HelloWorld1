package com.bridge.helloworld.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bridge.helloworld.R;
import com.bridge.helloworld.util.BaseActivity;

public class BroadcastActivity extends BaseActivity {

    private static final String TAG = "BroadcastActivity";
    private LocalReceiver localeReceiver;
    private LocalBroadcastManager localBroadcastManager;

    private IntentFilter mFilter;
    private Button send_broadcast;
    private NetworkChangeReceiver mNetworkChangeReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        localBroadcastManager  = LocalBroadcastManager.getInstance(this);//获取实例
        initBroadcast();
        Log.d(TAG, "onCreate: 注册广播接收器");
        mFilter = new IntentFilter();
        mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        mFilter.addAction("com.bridge.helloworld.broadcast.LOCAL_BROADCAST");
        localeReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localeReceiver,mFilter);

        mNetworkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(mNetworkChangeReceiver,mFilter);


    }

    /**
     * 初始化自定义广播
     */
    private void initBroadcast() {

        send_broadcast = findViewById(R.id.send_btn);
        Log.d(TAG, "initBroadcast: " + (R.id.send_btn));
        send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent("com.bridge.helloworld.broadcast.MY_BROADCAST");
                Intent intent = new Intent("com.bridge.helloworld.broadcast.LOCAL_BROADCAST");
//                sendBroadcast(intent);//发送一条标准广播
                //sendOrderedBroadcast(intent,null);//发送有序广播

                localBroadcastManager.sendBroadcast(intent);
            }

        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localeReceiver);
        unregisterReceiver(mNetworkChangeReceiver);
        Log.d(TAG, "onDestroy: 取消广播注册");
    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //Log.d(TAG, "onReceive: Network Changed!");
            //Toast.makeText(context,"Network Changed!---000",Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }

            if (networkInfo != null  && networkInfo.isAvailable()){
                Log.d(TAG, "onReceive: network is available");
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else {
                Log.d(TAG, "onReceive: network is unavailable");
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();

            }

        }
    }

    private class LocalReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"RECEIVE LOCAL BROADCAST RECEIVER",Toast.LENGTH_SHORT).show();
        }
    }
}
