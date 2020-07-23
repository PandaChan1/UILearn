package com.example.recyclertest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclertest.adapter.MultiTypeAdapter;
import com.example.recyclertest.beans.MultiBean;
import com.example.recyclertest.utils.Datas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiActivity extends AppCompatActivity {

    private static final String TAG = "MultiActivity";
    private RecyclerView mMultiView;
    private List<MultiBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        //找到控件
        mMultiView = findViewById(R.id.multi_view);
        //准备数据
        mData = new ArrayList<>();
        initDatas();
        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mMultiView.setLayoutManager(linearLayoutManager);
        //创建适配器
        MultiTypeAdapter adapter=new MultiTypeAdapter(mData);
        //设置适配器
        mMultiView.setAdapter(adapter);
    }

    private void initDatas() {
        Random random=new Random();
        for (int i = 0; i< Datas.icons.length; i++){
            MultiBean data=new MultiBean();
            data.pic=Datas.icons[i];  //utils包中的数据
            data.type=random.nextInt(3);
            Log.d(TAG,"type =="+data.type);
            mData.add(data);
        }
    }
}
