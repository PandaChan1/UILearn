package com.example.qqlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private static final String TAG="MainActivity";

    /**
     *Android的存储路径是按照Linux的方式，“/”表示根目录
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


    @Override
    protected void onResume() {
        super.onResume();
        try {
            FileInputStream fileInputStream=this.openFileInput("saveinfo.text");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            String info=bufferedReader.readLine();
            //对拿到的数据进行拆分
            String[] splits=info.split("\\*\\*\\*"); //正则表达式转译
            String account=splits[0];
            String password=splits[1];
            //回显
            mPassword.setText(password);
            mAccount.setText(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        String userText=mAccount.getText().toString();
        String PasswordText=mPassword.getText().toString();

        //账号密码判空并提示

        if (userText.length()==0) {
            //账号为空，弹出Toast提示
            Toast.makeText(this,"账号不可以为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(PasswordText)) {
            //密码不能为空
            Toast.makeText(this,"密码不可以为空",Toast.LENGTH_SHORT).show();
            return;
        }




        //把账号和密码保存起来
        saveaccountInfo(userText,PasswordText);
    }

    private void saveaccountInfo(String userText, String passwordText) {
        Log.d(TAG,"保存用户信息...");
        //怎么获取文件的保存路径？/data/data/com.example.qqlogin/files
        //结果：files fir==/data/user/0/com.example.qqlogin/files
        //getFilesDir()方法拿到的路径是/data/data/包名/files
        File filesdir=this.getFilesDir();
        Log.d(TAG,"files dir=="+ filesdir.toString());
        //获取缓存文件的路径
        File cachedir=this.getCacheDir();
        Log.d(TAG,"cache dir==" + cachedir);
        /**
         *cache dir==/data/user/0/com.example.qqlogin/cache
         *上面的路径是一个缓存路径，用于保存缓存文件，该目录下的文件，系统会根据存储情况进行清理
         * 假设不够用了，就会清理
         * files dir==/data/user/0/com.example.qqlogin/files
         * 下面这个是用于保存文件的路径，可以通过代码删除，也可以通过设置里的应用列表里的选项清理
         */
        File file=new File(filesdir,"saveinfo.text");
        try {
            if (!file.exists()){
            file.createNewFile();
        }

            FileOutputStream fos=new FileOutputStream(file);
            //以特定形式来存储
            //账号***密码
            fos.write((userText+"***"+passwordText).getBytes());
            Toast.makeText(this,"数据存储成功",Toast.LENGTH_SHORT).show();
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
