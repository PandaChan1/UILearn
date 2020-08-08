package com.example.datadeliver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendMsgActivity extends AppCompatActivity {

    private Button mSendMsg;
    private EditText mContent;
    private EditText mReciverPhoneNumEt;
    private static  final String TAG="SendMsgActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);
        initView();

        Intent intent=getIntent();
        if (intent != null) {
            String targetNumValue=intent.getStringExtra("targetnumKey");
            Log.d(TAG,"number is = "+targetNumValue);
            mReciverPhoneNumEt.setText(targetNumValue);
            Uri data=intent.getData();
            Log.d(TAG,"data is = "+data);

            //用toString().replace() 剔除掉scheme
            if (data != null) {
                String content = data.toString().replace("msg:","");
                mContent.setText(content);
            }
        }
    }

    private void initView() {
        mReciverPhoneNumEt = findViewById(R.id.reciver_phone_number_et);
        mContent = findViewById(R.id.msg_content_et);
        mSendMsg = findViewById(R.id.send_msg_btn);
    }
}
