package com.example.databasedemo;

import android.content.ContentValues;
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
       /* String sql="insert into "+Constants.TABLE_NAME+"(_id,name,age,salary,phone,address) values(?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{1,"cy",22,1,110,"USA"});*/


       //使用API插入数据
        ContentValues values=new ContentValues();
        //添加数据
        values.put("_id",2);
        values.put("name","huakai");
        values.put("age",30);
        values.put("salary",1);
        values.put("phone","911");
        values.put("address","xian");
        //insert第二个参数表示，当未设置值时，默认用null填充
        db.insert(Constants.TABLE_NAME,null,values);

        db.close();
    }

    public void delete(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql="delete from "+Constants.TABLE_NAME+" where age = 22";
        db.execSQL(sql);*/


        //返回的是删除的行数
        int result = db.delete(Constants.TABLE_NAME, null, null);


        Log.d(TAG,"delete_result=="+result);

        db.close();
    }

    public void updata(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql="update "+Constants.TABLE_NAME+" set salary = 2 where age = 22";
        db.execSQL(sql);*/


        ContentValues values=new ContentValues();
        values.put("phone",123456789);

        //第三个参数填null表示会修改整列phone的数据
        db.update(Constants.TABLE_NAME,values,null,null);

        db.close();

    }

    public void query(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
      /*  String sql="select * from "+Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);


        while (cursor.moveToNext()) {
            //获取name所在列数,使用getString（）方法获取该列的数据
            int index = cursor.getColumnIndex("name");
            String name=cursor.getString(index);
            Log.d(TAG,"name=="+name);

        }
        cursor.close();*/


        Cursor cursor = db.query(false, Constants.TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Log.d(TAG,"id=="+ id + "  name=="+name);
        }
        db.close();

    }
}
