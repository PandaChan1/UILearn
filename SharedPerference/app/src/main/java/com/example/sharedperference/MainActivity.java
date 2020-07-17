package com.example.sharedperference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch mAllowUnknowSources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到空间
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
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //需要对选择后的数据进行保存

    }
}
