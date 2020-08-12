package com.example.broadcastdemoforcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class SendOrderBroadcastActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);
    }

    /**
     * 点击事件
     */
    public void sendOrderBroadcast(View view){
        Intent intent=new Intent();
        intent.setAction(Constans.ACTION_ORDER_BROADCAST_TEST);
        Bundle bundle=new Bundle();
        bundle.putString("content","我是被发送的内容.....");
        sendOrderedBroadcast(intent,null,null,null,Activity.RESULT_OK,null,bundle);
    }
}
