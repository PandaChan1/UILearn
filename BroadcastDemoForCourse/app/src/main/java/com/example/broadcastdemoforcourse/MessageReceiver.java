package com.example.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MessageReceiver extends BroadcastReceiver {
    private static final String TAG = "MessageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG,"Action is = "+action);
        String content = intent.getStringExtra(Constans.KEY_CONTENT);
        Log.d(TAG,"content is = "+content);
    }
}
