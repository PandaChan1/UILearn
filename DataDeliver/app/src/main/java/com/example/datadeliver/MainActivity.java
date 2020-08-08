package com.example.datadeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     *
     * 这个方法跳转到第二个界面
     * @param view
     */
    public void skip2Second(View view){

        //创建意图对象
        Intent intent=new Intent(this,SecondActivity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("intkey",100);
        bundle.putBoolean("booleankey",true);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /**
     *
     * 传递一个对象到第二个界面
     * @param view
     */
    public void deliverObject(View view){

        /**
         *1、先实现界面跳转
         * 2、创建对象实现Parcelable接口
         * 3、用putExtra方式将对象扔进去
         * 4、都在第二个界面用key获取对象
         */
        Intent intent=new Intent(this,SecondActivity.class);

        User user=new User();
        user.setName("cy");
        user.setAge(20);
        user.setTall(168.9f);

        //putExtra可以传位图bitmap，也可以传string
        //bitmap实现了parcelable，String实现了Serializable(序列化)
//        Bitmap tempBitmap=null;
//        intent.putExtra("bitMapkey",tempBitmap);
//        intent.putExtra("Stringkey","String key");
        intent.putExtra("userkey",user);

        startActivity(intent);
    }


    public void register(View view){
        Intent intent=new Intent(this,LoginActivity.class);

        startActivity(intent);
    }

    public void phoneCall(View view){
        Intent intent=new Intent();


//        <action  name="android.intent.action.CALL" />
//        <category  name="android.intent.category.DEFAULT" />


        //Manifest中设置权限<uses-permission android:name="android.permission.CALL_PHONE"/>后
        // 还需要打开应用（本应用即DataDeliver的电话权限）
        intent.setAction("android.intent.action.CALL");
        intent.addCategory("android.intent.category.DEFAULT");

        Uri uri=Uri.parse("tel:10086");
        intent.setData(uri);



        startActivity(intent);
    }
}
