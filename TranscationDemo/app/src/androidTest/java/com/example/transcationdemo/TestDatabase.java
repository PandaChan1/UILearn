package com.example.transcationdemo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TestDatabase {

    private Context mAppContext;
    private static  final String TAG="TestDatabase";

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


        //普通方式写入3000条数据

        //获取当前时间
        long start=System.currentTimeMillis();

//        db.beginTransaction();
        for (int i=0;i<3000;i++){
            db.execSQL("insert into account values(1,'company',1000000)");
            db.execSQL("insert into account values(2,'myself',0)");


        }
//        db.endTransaction();


        //日志打印出录入3000条数据所用的时间
        Log.d(TAG,"usetime==  "+(System.currentTimeMillis()-start));

        //  事务耗时752ms  正常写入耗时29s  事务的高效性


        /*db.execSQL("insert into account values(1,'company',1000000)");
        db.execSQL("insert into account values(2,'myself',0)");*/

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
