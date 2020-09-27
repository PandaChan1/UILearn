package com.example.qqlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class qqlogin extends AppCompatActivity {
    private static final String TAG="qqlogin";

    private EditText mETaccount;
    private EditText mETpassword;
    private Button mBTNlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlogin);
        initView();
        initLinster();
    }

    private void initLinster() {
        mBTNlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEvent(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            FileInputStream fip=this.openFileInput("info.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(fip));
            String info=br.readLine();
            String[] splits = info.split("\\*\\*\\*");
            String account = splits[0];
            String passwd = splits[1];
            mETaccount.setText(account);
            mETpassword.setText(passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clickEvent(View v) {
        String account = mETaccount.getText().toString();
        String password = mETpassword.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        saveinfo(account,password);
    }

    private void saveinfo(String account, String password) {
        File filepath=this.getFilesDir();
        File file=new File(filepath,"info.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                FileOutputStream fos=new FileOutputStream(file);
                fos.write((account+"***"+password).getBytes());
                Toast.makeText(this,"数据保存成功",Toast.LENGTH_SHORT).show();
                fos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void initView() {
        mETaccount = this.findViewById(R.id.account);
        mETpassword = this.findViewById(R.id.password);
        mBTNlogin = this.findViewById(R.id.login);
    }
}
