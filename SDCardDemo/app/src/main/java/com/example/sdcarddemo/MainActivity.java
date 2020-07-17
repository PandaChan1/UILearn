package com.example.sdcarddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="MainActivity" ;
    private Button mBtnWriteToSDCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置布局
        mBtnWriteToSDCard = findViewById(R.id.btn_writedatatoSDCard);
        mBtnWriteToSDCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mBtnWriteToSDCard) {
            //写数据到SD卡
            /**
             *
             * SD卡读写需要在manifests文件中写明权限
             * <uses-permission></uses-permission>该方法声明权限
             */
            //获取sdcard路径
            File filepath = Environment.getExternalStorageDirectory();
            Log.d(TAG, "sdCard path==" + filepath);
            // File filepath=new File("/storage/sdcard"); //文件路径错误，storage下无sdcard文件，待修改
            File file = new File(filepath, "info.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("SDCard Learning Demo".getBytes());

                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
    }

