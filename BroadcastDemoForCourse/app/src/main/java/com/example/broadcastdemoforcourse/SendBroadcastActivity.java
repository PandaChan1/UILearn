package com.example.broadcastdemoforcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SendBroadcastActivity extends Activity {

    private EditText mInputBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        mInputBox = findViewById(R.id.et_input);
    }

    /**
     * 点击发送广播按钮后，这个方法就会被调用
     */
    public void senBroadcastMsg(View view){
            //被调用以后就发送广播
        String content = mInputBox.getText().toString();
        Intent intent=new Intent();
        intent.setAction(Constans.ACTION_SEND_MSG);
        intent.putExtra(Constans.KEY_CONTENT,content);
        //发送广播
        sendBroadcast(intent);
    }
}
