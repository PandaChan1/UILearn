package com.example.datadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserid;
    private EditText mPassword;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        //给按钮注册一个点击事件
        initListener();
    }

    private void initListener() {
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //处理注册
                handleRegister();
            }
        });
    }

    private void handleRegister() {
        String usernameText=mUserid.getText().toString().trim();
        if (TextUtils.isEmpty(usernameText)){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        String passwordText = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordText)){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent=new Intent(this,RegisterResultActivity.class);
        intent.putExtra("userNameKey",usernameText);
        intent.putExtra("passwordKey",passwordText);

        startActivity(intent);

        //结束当前界面，按返回不会回来
        this.finish();


    }

    private void initView() {
        mUserid = findViewById(R.id.userid);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.rregister_btn);
    }
}
