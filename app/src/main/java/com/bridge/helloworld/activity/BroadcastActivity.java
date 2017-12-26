package com.bridge.helloworld.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bridge.helloworld.R;

public class BroadcastActivity extends AppCompatActivity {

    private static final String TAG = "BroadcastActivity";
    private IntentFilter mFilter;
    private NetworkChangeReceiver mNetworkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Log.d(TAG, "onCreate: 注册广播接收器");
        mFilter = new IntentFilter();
        mFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        mNetworkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(mNetworkChangeReceiver,mFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetworkChangeReceiver);
        Log.d(TAG, "onDestroy: 取消广播注册");
    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Network Changed!");
            Toast.makeText(context,"Network Changed!---000",Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null  && networkInfo.isAvailable()){
                Log.d(TAG, "onReceive: network is available");
                Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
            }else {
                Log.d(TAG, "onReceive: network is unavailable");
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();

            }

        }
    }
}
