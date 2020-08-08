package com.example.datadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG="SecondActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        if (intent!=null){
            int value=intent.getIntExtra("intkey",-1);
            boolean booleanvalue = intent.getBooleanExtra("booleankey", false);
            //除了传递单个数据之外还可以传递同一类型的数组数据
            //intent.getBooleanArrayExtra();
            Log.d(TAG,"int value =="+value);
            Log.d(TAG,"boolean value =="+booleanvalue);



            //获取userkey，强转为User对象
            User user = intent.getParcelableExtra("userkey");
            if (user != null) {
                Log.d(TAG,"UserName == " + user.getName());
                Log.d(TAG,"UserAge == " + user.getAge());
                Log.d(TAG,"UserTall == " + user.getTall());
        }


        }
    }
}
