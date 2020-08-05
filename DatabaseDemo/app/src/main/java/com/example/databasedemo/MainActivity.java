package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //创建数据库 /data/data/com.example.databasedemo/databases 成功后会出现databases文件夹
        DatabaseHelper helper=new DatabaseHelper(this);
        helper.getWritableDatabase();
        //Dao类负责操作数据库，将创建数据库的代码放到Dao类种
    }
}
