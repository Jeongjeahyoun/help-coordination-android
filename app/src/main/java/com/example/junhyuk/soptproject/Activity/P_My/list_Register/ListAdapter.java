package com.example.junhyuk.soptproject.Activity.P_My.list_Register;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by 김 유나 on 2016-12-30.
 */

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    ArrayList<ListItem> itemDatas;
    ArrayList<ListItem> arSrc;
    // View.OnClickListener mOnClickListener;

    public ListAdapter(ArrayList<ListItem> itemDatas) {
        arSrc = itemDatas;
        this.itemDatas = itemDatas;
       // this.mOnClickListener = mOnClickListener;
    }

    public void setAdaper(ArrayList<ListItem> itemDatas){
        arSrc = itemDatas;

        this.itemDatas = new ArrayList<ListItem>();
        this.itemDatas.addAll(arSrc);

        notifyDataSetChanged();
    }

    @Override


    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent,false);
        ListViewHolder viewHolder = new ListViewHolder(itemView);

       // itemView.setOnClic7kListener(mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        holder.imageView2.setImageResource(arSrc.get(position).image);
        holder.nameView2.setText(arSrc.get(position).name);
        holder.memoView2.setText(arSrc.get(position).memo);


    }


    @Override
    public int getItemCount() {
        return (arSrc != null) ? arSrc.size() : 0;
    }

}
