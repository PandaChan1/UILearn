package com.example.databasedemo;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TestDatabase {

    private Context mAppContext;

    /**
     *
     * @Before 这个的作用是每次运行@Test前都要执行一次
     * @After 同理，每次运行@Test后都要执行的代码
     *
     */

    @Before
    public void useAppContext(){
        mAppContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //Junit4的断言，用来判断Context是否相等
        assertEquals("com.example.databasedemo", mAppContext.getPackageName());

    }

    public void testCreate(){
        //测试创建数据

    }

    @Test
    public void testInsert(){
        //测试插入数据
        Dao dao=new Dao(mAppContext);
        dao.insert();
    }

    @Test
    public void testUpdate(){
        //测试更新数据
        Dao dao=new Dao(mAppContext);
        dao.updata();
    }

    @Test
    public void testQuery(){
        //测试查询数据
        Dao dao=new Dao(mAppContext);
        dao.query();
    }

    @Test
    public void testDelete(){
        //测试删除数据
        Dao dao=new Dao(mAppContext);
        dao.delete();
    }

}
