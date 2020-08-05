package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.LongDef;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG="DatabaseHelper";
    /**
     *
     * @ context  上下文
     * @ name     数据库名称
     * @ factory  游标工厂
     * @ version  版本号
     */
    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }


    /**
     * Called when the database is created for the first time.
     * 第一次创建数据库时才会调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时的回调
        Log.d(TAG,"创建数据库...");
        //创建字段
        //sql: create table table_name(_id integer,name varchar,age integer,salary integer)
        String sql="create table " + Constants.TABLE_NAME + "(_id integer,name varchar,age integer,salary integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库时的回调
        Log.d(TAG,"升级数据库...");
        String sql;

        //sql: alter table table_name add phone integer;
        //oldVersion  newVersion 之前设置的version是1，改成>1时才会执行升级
//        String sql="alter table "+Constants.TABLE_NAME+" add phone integer";
//        db.execSQL(sql);


        //三个数据库版本，根据用户的老版本进行升级

        switch (oldVersion) {
            case 1:
                //添加address和phone字段
                sql = "alter table " + Constants.TABLE_NAME + " add phone integer,address varchar";
                db.execSQL(sql);
                break;
            case 2:
                //添加address字段
                sql = "alter table " + Constants.TABLE_NAME + " add address varchar";
                db.execSQL(sql);
                break;
            case 3:
                //
                break;
            }
        }
    }
