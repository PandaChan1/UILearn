package com.example.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 *
 * 第一步、创建一个类，并且继承自BroadcastReceiver
 * 第二部、在Manifest中静态注册
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    private static final String TAG ="BootCompleteReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG,"Action is == "+action);
        Log.d(TAG,"开机完成....");
        Toast.makeText(context,"开手机完成....",Toast.LENGTH_SHORT).show();
    }
}
