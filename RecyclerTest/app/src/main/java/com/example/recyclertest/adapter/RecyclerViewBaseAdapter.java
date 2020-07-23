package com.example.recyclertest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclertest.R;
import com.example.recyclertest.beans.ItemBean;

import java.util.List;

public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {

    private final List<ItemBean> mData;
    private OnItemClickLinstener mLinstener;

    public RecyclerViewBaseAdapter (List<ItemBean> data){this.mData=data;}

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //重构
        View view=getSubView(parent,viewType);
        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent,int viewType);


    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        //绑定Holder
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (mData!=null){
           return mData.size();
      }
       return 0;
    }

    public  void setOnItemClickLinstener(OnItemClickLinstener linstener){
        //设置一个监听，其实就是设置一个回调的接口
        this.mLinstener=linstener;
        
    };

    /**
     * 编写回调接口的步骤
     * 1、创建这个接口
     * 2、定义接口内部的方法
     * 3、提供设置接口的方法（其实就是外部实现）
     * 4、接口方法调用
     */
    
    public interface OnItemClickLinstener{
        void onItemClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private  ImageView mIcon;
        private  TextView mTitle;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mLinstener != null) {
                        mLinstener.onItemClick(mPosition);
                    }
                }
            });
        }

        public void setData(ItemBean itemBean,int position) {
           this.mPosition=position;
            //开始设置数据
            mTitle.setText(itemBean.title);
            mIcon.setImageResource(itemBean.icon);
        }
    }
}
