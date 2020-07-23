package com.example.recyclertest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclertest.R;
import com.example.recyclertest.beans.ItemBean;

import org.w3c.dom.Text;

import java.util.List;

public class GridViewAdapter extends RecyclerViewBaseAdapter {
//    private final List<ItemBean> mData;
//
//    //重写方法
//    public GridViewAdapter(List<ItemBean> data){
//        this.mData=data;
//    }

     //重构之后
    public GridViewAdapter(List<ItemBean> data){super(data);}


//    @NonNull
//    @Override
//    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //创建每个条目的UI
//        View view=View.inflate(parent.getContext(), R.layout.item_grid_view,null);
//        return new InnerHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
//        //绑定Holder
//        holder.setData(mData.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        //返回条目
//        if (mData!=null){
//            return mData.size();
//        }
//        return 0;
//    }
//
//    public class InnerHolder extends RecyclerView.ViewHolder {
//
//        private  TextView mTitle;
//        private  ImageView mIcon;
//
//        public InnerHolder(@NonNull View itemView) {
//            super(itemView);
//            mIcon = itemView.findViewById(R.id.icon);
//            mTitle = itemView.findViewById(R.id.title);
//        }
//
//        /**
//         * 设置数据
//         * @param itemBean
//         */
//
//        public void setData(ItemBean itemBean) {
//            mTitle.setText(itemBean.title);
//            mIcon.setImageResource(itemBean.icon);
//
//        }
//    }


    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.item_grid_view,null);
        return view;
    }
}
