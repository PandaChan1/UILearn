package com.example.manifestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {

    private TextView mInfo;
    private static final String TAG="SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mInfo = findViewById(R.id.info);


        Intent intent=getIntent();
        String account=intent.getStringExtra("account");
        String password=intent.getStringExtra("password");

        Log.d(TAG,"account:"+account);
        Log.d(TAG,"password:"+password);

        mInfo.setText("账号："+account+"  密码:"+password);

    }
}
