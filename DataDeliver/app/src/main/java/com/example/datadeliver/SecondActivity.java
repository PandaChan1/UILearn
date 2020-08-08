package com.example.datadeliver;

import android.content.Intent;
import android.os.Bundle;
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
            Log.d(TAG,"int value =="+value);
            Log.d(TAG,"boolean value =="+booleanvalue);
        }
    }
}
