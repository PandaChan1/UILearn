package com.example.activityforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 *数据回传案例
 *
 * 比如说，我们有一个需求：点击充值按钮，然后转到第二界面
 * 第二界面进行充值，充值完成后，告诉第一个界面：包括充值成功，充值失败
 */
public class MainActivity extends AppCompatActivity {

    private TextView mPayResultText;
    private Button mReCharge;
    private static  final int PAY_REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        mReCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置点击事件，跳转到第二个界面  进行充值

                Intent intent=new Intent(MainActivity.this,PayActivity.class);

//                startActivity(intent);
                //第一步使用startActivityForResult替换原来的startActivity
                startActivityForResult(intent,PAY_REQUEST_CODE);
            }
        });

    }

    private void initView() {
        mReCharge = findViewById(R.id.reCharge_btn);
        mPayResultText = findViewById(R.id.pay_result);
    }

    /**
     *
     * 返回的结果会在这里回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PAY_REQUEST_CODE) {
            String resultContent=null;
            if (resultCode==2) {
                //充值成功
                resultContent = data.getStringExtra("resultContent");
            }else if (resultCode==3){
                //充值失败
                resultContent=data.getStringExtra("resultContent");
            }
            mPayResultText.setText(resultContent);
        }
    }
}
