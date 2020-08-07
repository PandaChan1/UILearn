package com.example.manifestdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class skip2Browser extends AppCompatActivity {

    private static final String TAG="skip2BrowserActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2browser);
    }


    /**
     * 这个方法会在点击按钮时执行
     * @param view  这个就是我们点击的Button
     *
     *               Component=cmp=com.android.chrome/com.google.android.apps.chrome.Main
     *               //组件的名称，也就是Componentname = 包名/类的路径名称
     *              //以下是显式意图跳转到浏览器
     */
    public void skip2BrowserVisible(View view){
        Log.d(TAG,"skip2Browser");

        Intent intent=new Intent();
//        intent.setPackage("com.android.chrome");
//        如下，包名也可以和类名写在一起
        //第一种写法
        //intent.setClassName("com.android.chrome","com.google.android.apps.chrome.Main");

        //第二种写法
        ComponentName componentName=new ComponentName("com.android.chrome","com.google.android.apps.chrome.Main");
        intent.setComponent(componentName);

        startActivity(intent);

    }


    /**
     *
     * 通过隐式意图跳转到浏览器
     * 1、创建Intent对象
     * 2、第二步是给这个intent对象设置Action，设置它的Category，如果5.1以上系统需要设置包名
     * 3、startActivity跳转到另一个界面
     * * @param view
     */
    public void skip2BrowserInvisible(View view){

        Intent intent=new Intent();
//         <intent-filter>
//                <action android:name="android.intent.action.SEARCH"/>
//                <category android:name="android.intent.category.DEFAULT"/>
//            </intent-filter>

        intent.setAction("android.intent.action.SEARCH");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.android.chrome");

        startActivity(intent);

    }
}
