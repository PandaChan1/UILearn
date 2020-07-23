package com.example.recyclertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.recyclertest.adapter.GridViewAdapter;
import com.example.recyclertest.adapter.ListViewAdapter;
import com.example.recyclertest.adapter.RecyclerViewBaseAdapter;
import com.example.recyclertest.adapter.StaggerAdapter;
import com.example.recyclertest.beans.ItemBean;
import com.example.recyclertest.utils.Datas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mList;
    private List<ItemBean> mData;
    private RecyclerViewBaseAdapter mAdapter;

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
        //设置默认样式为ListView效果
        showList(true, false);

    }

    private void initListener() {
        mAdapter.setOnItemClickLinstener(new RecyclerViewBaseAdapter.OnItemClickLinstener() {
            @Override
            public void  onItemClick(int position) {
                //这里处理点击事件
                Toast.makeText(MainActivity.this, "你点击的是第 "+position+"个条目", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //List<DataBea>-->Adapter-->setAdapter-->显示数据
        //创建数据集合
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第 " + i + " 个条目";
            //添加到集合里面
            mData.add(data);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            //ListView效果
            case R.id.list_view_horizontal_reverse:
                Log.d(TAG, "点击了ListView的水平反向");
                showList(false, true);
                break;
            case R.id.list_view_horizontal_stander:
                Log.d(TAG, "点击了ListView的水平标准");
                showList(false, false);
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG, "点击了ListView的垂直反向");
                showList(true, true);
                break;
            case R.id.list_view_vertical_stander:
                Log.d(TAG, "点击了ListView的垂直标准");
                showList(true, false);
                break;

            //GridView效果
            case R.id.grid_view_horizontal_reverse:
                showGrid(false,true);
                break;
            case R.id.grid_view_horizontal_stander:
                showGrid(false,false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGrid(true,true);
                break;
            case R.id.grid_view_vertical_stander:
                showGrid(true,false);
                break;

            //StaggerViwe效果
            case R.id.stagger_view_horizontal_reverse:
                showStagger(false,true);
                break;
            case R.id.stagger_view_horizontal_stander:
                showStagger(false,false);
                break;
            case R.id.stagger_view_vertical_reverse:
                showStagger(true,true);
                break;
            case R.id.stagger_view_vertical_stander:
                showStagger(true,false);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 这个方法实现瀑布流效果
     */
    private void showStagger(boolean isVertical,boolean isReverse) {
        //创建布局管理器
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,isVertical?StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
        //设置正向还是反向
        layoutManager.setReverseLayout(isReverse);
        mList.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter = new StaggerAdapter(mData);
        //设置到RecyclerView适配器
        mList.setAdapter(mAdapter);

        //初始化监听事件
        initListener();

    }

    /**
     * 方法用于实现GridView效果
     */
    private void showGrid(boolean isVertical,boolean isReverse) {
        //创建布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        //设置垂直还是水平
        layoutManager.setOrientation(isVertical? LinearLayoutManager.VERTICAL: LinearLayoutManager.HORIZONTAL);
        //设置正向还是反向
        layoutManager.setReverseLayout(isReverse);
        mList.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter=new GridViewAdapter(mData);
        //设置到RecyclerView适配器
        mList.setAdapter(mAdapter);

        //初始化监听事件
        initListener();
    }

    private void showList(boolean isVertical, boolean isReverse) {
        //RecyclerView需要设置布局样式，即布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //通过设置布局管理器来实现水平垂直效果
        //设置垂直还是水平
        manager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置正向还是反向
        manager.setReverseLayout(isReverse);
        mList.setLayoutManager(manager);
        //创建适配器
        mAdapter = new ListViewAdapter(mData);
        //设置到RecyclerView里面
        mList.setAdapter(mAdapter);

        //初始化监听事件
        initListener();

    }
}
