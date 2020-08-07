package com.example.manifestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText mAcount;
    private EditText mPass;
    private Button mLogin;
    private static final String TAG="MainActivity";

    /**
     *
     *实现界面的跳转并且把数据传到另外一个界面
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录按钮被点击
                Log.d(TAG,"login click...");
                handlerLogin();
            }
        });
    }

    private void handlerLogin(){
        String accountText=mAcount.getText().toString().trim();
        if (TextUtils.isEmpty(accountText)){
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }

        String passText=mPass.getText().toString().trim();
        if (TextUtils.isEmpty(passText)){
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //有密码和帐号以后，要将数据传递到另一个界面
        Intent intent=new Intent(this,SecondActivity.class);
        //传递数据1
       /* intent.putExtra("account",accountText);
        intent.putExtra("password",passText);*/
        //传递数据2
        Bundle bundle=new Bundle();
        bundle.putString("account",accountText);
        bundle.putString("password",passText);
        intent.putExtras(bundle);

        Log.d(TAG,"account:"+accountText);
        Log.d(TAG,"password:"+passText);
        startActivity(intent);
    }

    private void initView() {
        mAcount = findViewById(R.id.account);
        mPass = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
    }
}
