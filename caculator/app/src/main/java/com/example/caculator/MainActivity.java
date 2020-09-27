package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="MainActivity";
    private TextView mBtn_cancel;
    private TextView mBtn_plusOrminus;
    private TextView mBtn_mod;
    private TextView mBtn_divides;
    private TextView mBtn_plus;
    private TextView mBtn_minus;
    private TextView mBtn_mult;
    private TextView mBtn_equals;
    private TextView mBtn_one;
    private TextView mBtn_two;
    private TextView mBtn_three;
    private TextView mBtn_four;
    private TextView mBtn_five;
    private TextView mBtn_six;
    private TextView mBtn_seven;
    private TextView mBtn_eight;
    private TextView mBtn_nine;
    private TextView mBtn_zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //提取方法
        initView();
        //设置点击事件
        initClick();
    }

    /**
     * 设置点击事件
     */
    private void initClick() {
        //第一种方式
        mBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"content == "+((TextView)v).getText().toString());
            }
        });
        //第二种方式,实现接口
        mBtn_plusOrminus.setOnClickListener(this);
        mBtn_plus.setOnClickListener(this);
        mBtn_mult.setOnClickListener(this);
        mBtn_mod.setOnClickListener(this);
        mBtn_minus.setOnClickListener(this);
        mBtn_divides.setOnClickListener(this);
        mBtn_equals.setOnClickListener(this);

        mBtn_one.setOnClickListener(this);
        mBtn_two.setOnClickListener(this);
        mBtn_three.setOnClickListener(this);
        mBtn_four.setOnClickListener(this);
        mBtn_five.setOnClickListener(this);
        mBtn_six.setOnClickListener(this);
        mBtn_seven.setOnClickListener(this);
        mBtn_eight.setOnClickListener(this);
        mBtn_nine.setOnClickListener(this);
        mBtn_zero.setOnClickListener(this);

    }

    /**
     * 找到控件
     */
    private void initView() {
        mBtn_cancel=this.findViewById(R.id.cancel);
        mBtn_divides=this.findViewById(R.id.divides);
        mBtn_plusOrminus=this.findViewById(R.id.plus_or_minus);
        mBtn_mod=this.findViewById(R.id.mod);
        mBtn_equals=this.findViewById(R.id.equals);
        mBtn_plus=this.findViewById(R.id.plus);
        mBtn_minus=this.findViewById(R.id.minus);
        mBtn_mult=this.findViewById(R.id.mult);
        mBtn_one=this.findViewById(R.id.one);
        mBtn_two=this.findViewById(R.id.two);
        mBtn_three=this.findViewById(R.id.three);
        mBtn_four=this.findViewById(R.id.four);
        mBtn_five=this.findViewById(R.id.five);
        mBtn_six=this.findViewById(R.id.six);
        mBtn_seven=this.findViewById(R.id.seven);
        mBtn_eight=this.findViewById(R.id.eight);
        mBtn_nine=this.findViewById(R.id.nine);
        mBtn_zero=this.findViewById(R.id.zero);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.equals:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.divides:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.plus:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.plus_or_minus:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.mod:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.mult:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.minus:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.one:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.two:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.three:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.four:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.five:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.six:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.seven:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.eight:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.nine:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
            case R.id.zero:
                Log.d(TAG,"text == "+((TextView)v).getText().toString());
                break;
        }
    }


    /*第一种方式处理点击事件，xml文件中设置onClick属性方法，在MainActivity中实现方法*/
//    public void cancelOnClick(View view){
//        Log.d(TAG,"cancel is click......");
//        if (view instanceof TextView) {
//            String s = ((TextView) view).getText().toString();
//            Log.d(TAG,"text =="+s);
//        }
//    }
//    public void onOrangeClick(View view){
//        Log.d(TAG,"onOrange click......");
//        if (view instanceof TextView){
//            String s = ((TextView) view).getText().toString();
//            Log.d(TAG,"text =="+s);
//        }
//    }

}
