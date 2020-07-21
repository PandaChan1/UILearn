package com.example.recyclertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclertest.adapter.ListViewAdapter;
import com.example.recyclertest.beans.ItemBean;
import com.example.recyclertest.utils.Datas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private RecyclerView mList;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mList = findViewById(R.id.recycler_view);
        //准备数据
        /**
         * 一般来说数据是从网络中获取的，这里只做演示
         */
        initData();
    }

    private void initData() {
        //List<DataBea>-->Adapter-->setAdapter-->显示数据
        //创建数据集合
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i< Datas.icons.length; i++){
            ItemBean data=new ItemBean();
            data.icon=Datas.icons[i];
            data.title="我是第 "+i+" 个条目";
            //添加到集合里面
            mData.add(data);

            /**
             * RecyclerView需要设置布局样式，即布局管理器
             */
            LinearLayoutManager manager=new LinearLayoutManager(this);
            mList.setLayoutManager(manager);
            //创建适配器
            ListViewAdapter adapter=new ListViewAdapter(mData);
            //设置到RecyclerView里面
            mList.setAdapter(adapter);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            //ListView效果
            case R.id.list_view_horizontal_reverse:
                Log.d(TAG,"点击了ListView的水平反向");
                break;
            case R.id.list_view_horizontal_stander:
                Log.d(TAG,"点击了ListView的水平标准");
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG,"点击了ListView的垂直反向");
                break;
            case R.id.list_view_vertical_stander:
                Log.d(TAG,"点击了ListView的垂直标准");
                break;

                //GridView效果
            case R.id.grid_view_horizontal_reverse:
                break;
            case R.id.grid_view_horizontal_stander:
                break;
            case R.id.grid_view_vertical_reverse:
                break;
            case R.id.grid_view_vertical_stander:
                break;

                //StaggerViwe效果
            case R.id.stagger_view_horizontal_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_vertical_stander:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
