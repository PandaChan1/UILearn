package com.example.activityforresultdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {

    private Button mStartPay;
    private EditText mInputBox;
    private Button mCancelPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initView();

        initListener();

    }

    private void initListener() {
        mStartPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePay();
            }
        });


        mCancelPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCancel();
            }
        });



    }


    /**
     *setResult()，用来设置结果码
     * <p/>
     * 结果码的作用：用于区分结果，一般来说，一个数字代表一种结果
     * <p/>
     * 我们这里，使用2表示充值成功，3表示充值失败
     * <p/>
     * Activity中也有一个常量，用于表示成功的是-1，失败的是0
     */
    private void handleCancel() {

        Intent intent=new Intent();
        intent.putExtra("resultContent","取消充值");

        setResult(3,intent);
        finish();
    }

    private void handlePay() {
        String payNumber = mInputBox.getText().toString().trim();
        if (TextUtils.isEmpty(payNumber)){
            Toast.makeText(PayActivity.this,"请输入充值金额",Toast.LENGTH_SHORT).show();
            return;
        }
        //网络访问，进行充值
        //setResult方法有两个重载，一个是只有resultCode的，两外一个还有Intent
        Intent intent=new Intent();
        intent.putExtra("resultContent","充值成功");
        setResult(2,intent);
        finish();
    }

    private void initView() {
        mInputBox = findViewById(R.id.pay_input_box);
        mStartPay = findViewById(R.id.pay_start_btn);
        mCancelPay = findViewById(R.id.pay_cancel_btn);
    }
}
