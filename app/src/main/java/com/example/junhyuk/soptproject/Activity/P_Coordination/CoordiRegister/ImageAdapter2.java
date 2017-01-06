package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiRegister;

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

public class ImageAdapter2 extends  RecyclerView.Adapter<ImageViewHolder2>{
    ArrayList<Closet> closets;
    Context context;
    CodiRegisterActivity codiRegisterActivity;

    public ImageAdapter2(ArrayList<Closet> closets, Context context, CodiRegisterActivity codiRegisterActivity) {
        this.closets = closets;
        this.context = context;
        this.codiRegisterActivity = codiRegisterActivity;
    }



    @Override
    public ImageViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        // Log.i("myTag", "onCreateViewHolder()");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.codiregister_item_recyclerview, parent, false);
        ImageViewHolder2 viewHolder = new ImageViewHolder2(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder2 holder, final int position) {
        // Log.i("myTag", "onBindViewHolder()");
        //Log.i("myTag", closets.get(position).getClothImage());
        Glide.with(context).load(closets.get(position).getClothImage()).into(holder.codiregister_item_recyclerview);
        holder.codiregister_item_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codiRegisterActivity.onItemClick(closets.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return closets.size();
    }


}



