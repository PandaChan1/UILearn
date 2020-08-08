package com.example.datadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);

        TextView result=findViewById(R.id.tv_result);
        Intent intent = getIntent();
        if (intent != null) {
            String userName = intent.getStringExtra("userNameKey");
            result.setText("恭喜【"+userName+"】已经注册成功啦！");
        }

    }
}
