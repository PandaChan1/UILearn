package com.example.databasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dao {

    private final DatabaseHelper mHelper;
    private static  final String TAG="Dao";

    //这个类用于操作数据库的增删改查
    public Dao(Context context){

        //创建数据库
        mHelper = new DatabaseHelper(context);
    }
    public void insert(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql="insert into "+Constants.TABLE_NAME+"(_id,name,age,salary,phone,address) values(?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"cy",22,1,110,"USA"});
        db.close();
    }

    public void delete(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql="delete from "+Constants.TABLE_NAME+" where age = 22";
        db.execSQL(sql);
        db.close();
    }

    public void updata(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql="update "+Constants.TABLE_NAME+" set salary = 2 where age = 22";
        db.execSQL(sql);
        db.close();

    }

    public void query(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql="select * from "+Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);


        while (cursor.moveToNext()) {
            //获取name所在列数,使用getString（）方法获取该列的数据
            int index = cursor.getColumnIndex("name");
            String name=cursor.getString(index);
            Log.d(TAG,"name=="+name);

        }
        cursor.close();
        db.close();

    }
}
