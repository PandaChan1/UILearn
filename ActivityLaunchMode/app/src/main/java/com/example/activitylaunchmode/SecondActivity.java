package com.example.activitylaunchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void openFirst(View view){
        //去打开第一个Activity
        startActivity(new Intent(this,FirstActivity.class));
    }

    public void openSecond(View view){
        //去打开第二个Activity
        startActivity(new Intent(this,SecondActivity.class));
    }
}
