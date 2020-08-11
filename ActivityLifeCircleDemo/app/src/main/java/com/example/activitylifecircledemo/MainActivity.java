package com.example.activitylifecircledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MSG_RECORD ="msg_record";
    private static final String RECORD_KEY ="record";
    private Button mSendMsg;
    private EditText mContentBox;
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

        SharedPreferences sharedPreferences = this.getSharedPreferences(MSG_RECORD, MODE_PRIVATE);
        String record = sharedPreferences.getString(RECORD_KEY, null);

        if (!TextUtils.isEmpty(record)) {
            mContentBox.setText(record);
        }

    }

    private void initListener() {
        mSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取短信内容
                String context = mContentBox.getText().toString().trim();
                if (TextUtils.isEmpty(context)) {
                    //判空
                    Toast.makeText(MainActivity.this,"请输入短信内容",Toast.LENGTH_SHORT).show();
                    return;
                }
                //
                Log.d(TAG,"发送短信...."+context);

            }
        });
    }

    private void initView() {
        mContentBox = findViewById(R.id.content);
        mSendMsg = findViewById(R.id.send);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String context = mContentBox.getText().toString().trim();
        //把数据保存到sharedPreferences里。
        if (!TextUtils.isEmpty(context)) {
            SharedPreferences sharedPreferences = this.getSharedPreferences(MSG_RECORD, MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(RECORD_KEY,context);
            edit.commit();
        }

    }
}
