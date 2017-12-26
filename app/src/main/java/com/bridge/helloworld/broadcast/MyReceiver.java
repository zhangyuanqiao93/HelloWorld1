package com.bridge.helloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Log.d(TAG, "onReceive: MyReceiver");
        Toast.makeText(context,"received in MyBroadcastReceiver",Toast.LENGTH_SHORT).show();

        //获得优先级，可以在此处截断广播
        abortBroadcast();
    }
}
