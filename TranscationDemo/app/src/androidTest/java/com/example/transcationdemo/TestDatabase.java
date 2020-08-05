package com.example.transcationdemo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TestDatabase {

    private Context mAppContext;

    @Before
    public void useAppContext() {
        // Context of the app under test.
        mAppContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.transcationdemo", mAppContext.getPackageName());
    }

    @Test
    public void testDatabase(){
        //测试数据库创建
        DatabaseHelper helper=new DatabaseHelper(mAppContext);
        helper.getReadableDatabase();
    }

    @Test
    public void testinsert(){
        //测试数据库插入
        DatabaseHelper helper=new DatabaseHelper(mAppContext);
        SQLiteDatabase db = helper.getReadableDatabase();


        db.execSQL("insert into account values(1,'company',1000000)");
        db.execSQL("insert into account values(2,'myself',0)");

        db.close();

    }

    @Test
    public void testupdate(){
        //在这里转账，公司账号-12000，个人账号+12000
        DatabaseHelper helper=new DatabaseHelper(mAppContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        //开始事务
        db.beginTransaction();

        try {
            db.execSQL("update account set money = 1000000-120000 where name ='company'");


           /* //在这里让其发生异常，模拟转账时断电
            int i=10/0;*/

            db.execSQL("update account set money = 120000 where name ='myself'");



            db.setTransactionSuccessful();



        }catch (Exception e){
            //处理异常
            throw new RuntimeException("停电了");

        }finally {

            db.endTransaction();
            db.close();
        }




    }
}
