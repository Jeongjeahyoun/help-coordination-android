package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by jeongjeahyeon on 2017. 1. 3..
 */

public class CodiMainAdapter extends RecyclerView.Adapter<com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain.ViewHolder>{


    public CodiMainAdapter() {
    }

    ArrayList<CodiItemDatas> mDatas;
    ArrayList<CodiItemDatas> arSrc;
    //View.OnClickListener mOnClickListener;

    public CodiMainAdapter(ArrayList<CodiItemDatas> mDatas) {
        this.mDatas = mDatas;
        arSrc = mDatas;

        //this.mOnClickListener = mOnClickListener;
    }

    public void setAdaper(ArrayList<CodiItemDatas> mDatas){
        arSrc = mDatas;

        this.mDatas = new ArrayList<CodiItemDatas>();
        this.mDatas.addAll(arSrc);

        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.codimain_item_recyclerview, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        //itemView.setOnClickListener(mOnClickListener);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.profile_nickname .setText(mDatas.get(position).profile_nickname );
        holder.image.setImageResource(mDatas.get(position).image);
        holder.content.setText(mDatas.get(position).content);


    }

    @Override
    public int getItemCount() {
        return (mDatas != null) ? mDatas.size() : 0;
    }

}

