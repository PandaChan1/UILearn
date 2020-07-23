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

public class ListViewAdapter extends RecyclerViewBaseAdapter{


    public ListViewAdapter(List<ItemBean> data){
        super(data);
    }

    /**
     * 这个方法创建条目的View
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return view;
    }


//    @NonNull
//    @Override
//    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        //传进去的view就是每个条目的界面，即每个条目的layout形式
//        /**
//         * 两个步骤
//         * 1、拿到view
//         * 2、创建ViewHolder
//         */
//        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
//        return new InnerHolder(view);
//    }
//
//    /**
//     *这个方法用于绑定Holder，一般用来设置数据
//     * @param holder
//     * @param position
//     */
//    @Override
//    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHolder holder, int position) {
//    //在这里设置数据
//        holder.setData(mData.get(position));
//    }
//

//    /**
//     * 返回条目个数
//     * @return
//     */
//    @Override
//    public int getItemCount() {
//        if (mData!=null){
//            return mData.size();
//        }
//        return 0;
//    }
//
//
//    public class InnerHolder extends RecyclerView.ViewHolder {
//
//        private  ImageView mIcon;
//        private  TextView mTitle;
//
//        public InnerHolder(@NonNull View itemView) {
//            super(itemView);
//            //找到条目的控件
//            mIcon = itemView.findViewById(R.id.icon);
//            mTitle = itemView.findViewById(R.id.title);
//        }
//
//        /**
//         * 这个方法用于设置数据
//         * @param itemBean
//         */
//        public void setData(ItemBean itemBean) {
//            //开始设置数据
//            mIcon.setImageResource(itemBean.icon);
//            mTitle.setText(itemBean.title);
//        }
//    }
}
