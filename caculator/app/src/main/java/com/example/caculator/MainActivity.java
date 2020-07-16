package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private static final String TAG="MainActivity";
    private TextView mcancel;
    private TextView mplusormanus;
    private TextView mdengyu;
    private TextView mjian;
    private TextView mjia;
    private TextView mmod;
    private TextView mchu;
    private TextView mnumOne;
    private TextView mnumTwo;
    private TextView mnumThree;
    private TextView mnumFour;
    private TextView mnumFive;
    private TextView mnumSix;
    private TextView mnumSeven;
    private TextView mnumEight;
    private TextView mnumNine;
    private TextView mnumZero;
    private TextView mcheng;
    private TextView mdot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        initView();
        //设置点击事件
        initClickEvent();
    }

    private void initClickEvent() {
        //第一种方法设置点击事件
        mcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
            }
        });
        //第二种方法设置点击事件
        mplusormanus.setOnClickListener(this);
        mnumOne.setOnClickListener(this);
        mcheng.setOnClickListener(this);
        mchu.setOnClickListener(this);
        mdengyu.setOnClickListener(this);
        mdot.setOnClickListener(this);
        mjia.setOnClickListener(this);
        mjian.setOnClickListener(this);
        mmod.setOnClickListener(this);
        mnumEight.setOnClickListener(this);
        mnumFive.setOnClickListener(this);
        mnumFour.setOnClickListener(this);
        mnumNine.setOnClickListener(this);
        mnumSeven.setOnClickListener(this);
        mnumSix.setOnClickListener(this);
        mnumThree.setOnClickListener(this);
        mnumTwo.setOnClickListener(this);
        mnumZero.setOnClickListener(this);
    }

    /**
     * 提取方法
     */
    private void initView() {
        mcancel = findViewById(R.id.tv_cancel);
        mplusormanus = findViewById(R.id.tv_plusormanus);
        mmod = findViewById(R.id.tv_mod);
        mchu = findViewById(R.id.tv_chu);
        mnumOne = findViewById(R.id.tv_number_one);
        mnumTwo = findViewById(R.id.tv_number_two);
        mnumThree = findViewById(R.id.tv_number_three);
        mnumFour = findViewById(R.id.tv_number_four);
        mnumFive = findViewById(R.id.tv_number_five);
        mnumSix = findViewById(R.id.tv_number_six);
        mnumSeven = findViewById(R.id.tv_number_seven);
        mnumEight = findViewById(R.id.tv_number_eight);
        mnumNine = findViewById(R.id.tv_number_nine);
        mnumZero = findViewById(R.id.tv_number_zero);
        mcheng = findViewById(R.id.tv_cheng);
        mdot = findViewById(R.id.tv_dot);
        mjia = findViewById(R.id.tv_jia);
        mjian = findViewById(R.id.tv_jian);
        mdengyu = findViewById(R.id.tv_dengyu);
    }

    @Override
    public void onClick(View v) {
        /**
         * 如果多个控件设置点击事件，可以使用switch判断
         */
        switch (v.getId()){
            case R.id.tv_plusormanus:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_one:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_cheng:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_chu:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_jia:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_jian:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_mod:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_dot:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_dengyu:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_zero:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_two:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_three:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_four:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_five:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_six:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_seven:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_eight:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
            case R.id.tv_number_nine:
                Log.d(TAG,"content=="+((TextView)v).getText().toString());
                break;
        }

    }
//    public void oneOnclick(View view){
//        Log.d(TAG,"onew be click");
//        if (view instanceof TextView){
//            String orangeclick=((TextView) view).getText().toString();
//            Log.d(TAG, "text=="+orangeclick);
//        }
//    }
//    public void onOrangeclick(View view){
//        Log.d(TAG,"onOrangeclick");
//        if (view instanceof TextView){
//            String oneclick=((TextView) view).getText().toString();
//            Log.d(TAG,"text=="+oneclick);
//        }
//    }
}
