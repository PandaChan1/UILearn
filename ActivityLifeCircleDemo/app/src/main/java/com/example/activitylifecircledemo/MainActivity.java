package com.example.activitylifecircledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mSendMsg;
    private EditText mContentBox;
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取短信内容
                String context = mContentBox.getText().toString().trim();
                //
                Log.d(TAG,"发送短信....");

            }
        });
    }

    private void initView() {
        mContentBox = findViewById(R.id.content);
        mSendMsg = findViewById(R.id.send);
    }


}
