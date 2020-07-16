package com.example.qqlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private static final String TAG="MainActivity";

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一步，找到控件
        initView();
        //第二部，设置监听事件
        initListener();
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击了登录按钮...");
                handlerLoginEvent(v);
            }
        });
    }

    private void handlerLoginEvent(View view) {
        //第三步，拿到界面上的内容，账号和密码
        String userText=((EditText)view).getText().toString();
        String PasswordText=((EditText)view).getText().toString();
        //把账号和密码保存起来
        saveaccountInfo(userText,PasswordText);
    }

    private void saveaccountInfo(String userText, String passwordText) {
        Log.d(TAG,"保存用户信息...");
        File file=new File("saveinfo.text");
        try {
            if (!file.exists()){
            file.createNewFile();
        }

            FileOutputStream fos=new FileOutputStream(file);
            //以特定形式来存储
            //账号*-*密码
            fos.write((userText+"*-*"+passwordText).getBytes());

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 找到控件的方法
     */
    private void initView() {
        mAccount = findViewById(R.id.et_account);
        mPassword = findViewById(R.id.et_password);
        mLogin = findViewById(R.id.btn_login);
    }
}
