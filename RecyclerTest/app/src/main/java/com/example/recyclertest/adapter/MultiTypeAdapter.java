package com.example.recyclertest.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclertest.R;
import com.example.recyclertest.beans.MultiBean;

import java.util.List;

public class MultiTypeAdapter extends RecyclerView.Adapter {

    //定义三个常量，代表三种类型
    public static final int TYPE_FULL_IMAGE=0;
    public static final int TYPE_LEFT_IMAGE=1;
    public static final int TYPE_THREE_IMAGE=2;

    private final List<MultiBean> mData;

    public MultiTypeAdapter(List<MultiBean> data){
        this.mData=data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //TODO:这里面创建ViewHolder
        if (viewType==TYPE_FULL_IMAGE){
            view=View.inflate(parent.getContext(), R.layout.item_full_image,null);
            return new FullImageHolder(view);
        }else if (viewType==TYPE_LEFT_IMAGE){
            view=View.inflate(parent.getContext(),R.layout.item_left_image,null);
            return new LeftImageHolder(view);
        }else{
            view=View.inflate(parent.getContext(),R.layout.item_three_image,null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //这里就不设置数据了

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }


    //复写一个方法，根据条件来返回条目类型
    @Override
    public int getItemViewType(int position) {
        MultiBean multiBean=mData.get(position);
        if (multiBean.type==0){
            return TYPE_FULL_IMAGE;
        }else if (multiBean.type==1){
            return TYPE_LEFT_IMAGE;
        }else{
            return TYPE_THREE_IMAGE;
        }
    }

    private class FullImageHolder extends RecyclerView.ViewHolder{

        public FullImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class LeftImageHolder extends RecyclerView.ViewHolder{

        public LeftImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ThreeImageHolder extends RecyclerView.ViewHolder{

        public ThreeImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
