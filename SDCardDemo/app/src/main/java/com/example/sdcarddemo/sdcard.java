package com.example.sdcarddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class sdcard extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn_sdcard_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        mBtn_sdcard_save = this.findViewById(R.id.btn_sdcard_save);
        mBtn_sdcard_save.setOnClickListener(this);
    }

    //mainfest文件中声明权限仍然 permission denied 解决方案
    // 设置中找到app，给予其存储权限
    @Override
    public void onClick(View v) {
        if (v==mBtn_sdcard_save) {
            File filepath = Environment.getExternalStorageDirectory();
            try {
                File file = new File(filepath, "saveinfo.txt");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("SDcard save success".getBytes());
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
