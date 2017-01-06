package com.example.junhyuk.soptproject.Activity.P_Coordination.RepleRegister;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.junhyuk.soptproject.Model.Closet;
import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by jeongjeahyeon on 2017. 1. 5..
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder>{
    ArrayList<Closet> closets;
    Context context;
    RepleRegisterActivity repleRegisterActivity;

    public ImageAdapter(ArrayList<Closet> closets, Context context, RepleRegisterActivity repleRegisterActivity) {
        this.closets = closets;
        this.context = context;
        this.repleRegisterActivity = repleRegisterActivity;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // Log.i("myTag", "onCreateViewHolder()");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.repleregister_item_recyclerview, parent, false);
        ImageViewHolder viewHolder = new ImageViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
       // Log.i("myTag", "onBindViewHolder()");
        //Log.i("myTag", closets.get(position).getClothImage());
        Glide.with(context).load(closets.get(position).getClothImage()).into(holder.repleregister_item_recyclerview);
        holder.repleregister_item_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repleRegisterActivity.onItemClick(closets.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return closets.size();
    }


}

