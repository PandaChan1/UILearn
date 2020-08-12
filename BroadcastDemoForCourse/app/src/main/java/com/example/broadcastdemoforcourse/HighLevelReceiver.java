package com.example.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HighLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "HighLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"high action is = "+intent.getAction());
        //终止往下按传达
        //abortBroadcast();
        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG,"content --> "+content);
        resultExtras.putCharSequence("content","我是被修改过的广播内容....");
        setResultExtras(resultExtras);
    }
}
