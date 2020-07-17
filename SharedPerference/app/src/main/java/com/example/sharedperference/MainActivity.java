package com.example.sharedperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch mAllowUnknowSources;
    private static final String TAG="SharedPerference";
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mAllowUnknowSources = findViewById(R.id.sw_allowUnknowSources);

        /**
         * 设置监听的两种方法
         *  mAllowUnknowSources.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         *             @Override
         *             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
         *
         *             }
         *         });
         */
       mAllowUnknowSources.setOnCheckedChangeListener(this);
        mSharedPreferences = this.getSharedPreferences("setting_info",MODE_PRIVATE);
        boolean state = mSharedPreferences.getBoolean("state", false);//默认值设为false
        mAllowUnknowSources.setChecked(state);//设置switch的状态
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //需要对选择后的数据进行保存
        Log.d(TAG,"current state=="+isChecked);
        /**
         * 一、打开编辑器Editor
         * 二、存入数据
         * 三、提交保存数据
         * 数据存储的位置/data/data/包名/shared——prefs，以xml文件形式储存
         */
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putBoolean("state",isChecked);
        edit.commit();
    }
}
