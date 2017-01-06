package com.example.junhyuk.soptproject.Activity.P_Coordination.Reple;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by jeongjeahyeon on 2017. 1. 2..
 */

public class RepleAdapter extends RecyclerView.Adapter<ViewHolder>{


    ArrayList<ItemDatas> mDatas;
    View.OnClickListener mOnClickListener;

    public RepleAdapter(ArrayList<ItemDatas> mDatas, View.OnClickListener mOnClickListener) {
        this.mDatas = mDatas;
        this.mOnClickListener = mOnClickListener;
    }

    public void setAdapter(ArrayList<ItemDatas> mDatas){
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reple_item_recyclerview, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        itemView.setOnClickListener(mOnClickListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.rippleImage1.setImageResource(mDatas.get(position).rippleImage1);
        holder.rippleImage2.setImageResource(mDatas.get(position).rippleImage2);
        holder.rippleImage3.setImageResource(mDatas.get(position).rippleImage3);
        holder.rippleImage4.setImageResource(mDatas.get(position).rippleImage4);
        holder.rippleImage5.setImageResource(mDatas.get(position).rippleImage5);
        holder.rippleImage6.setImageResource(mDatas.get(position).rippleImage6);
        holder.rippleProfileName.setText(mDatas.get(position).rippleProfileName);
        holder.txt_ripple.setText(mDatas.get(position).txt_ripple);
        holder.rippleLikeNum.setText(mDatas.get(position).rippleLikeNum);


    }

    @Override
    public int getItemCount() {
        return (mDatas != null) ? mDatas.size() : 0;
    }

}