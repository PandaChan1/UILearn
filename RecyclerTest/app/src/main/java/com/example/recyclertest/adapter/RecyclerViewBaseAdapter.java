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
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData!=null){
           return mData.size();
      }
       return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private  ImageView mIcon;
        private  TextView mTitle;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);
        }

        public void setData(ItemBean itemBean) {
            mTitle.setText(itemBean.title);
            mIcon.setImageResource(itemBean.icon);
        }
    }
}
