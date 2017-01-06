package com.example.junhyuk.soptproject.Activity.P_Coordination.RepleRegister;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.junhyuk.soptproject.R;

/**
 * Created by jeongjeahyeon on 2017. 1. 5..
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {


    public ImageButton repleregister_item_recyclerview;

    public ImageViewHolder(View itemView) {
        super(itemView);
        repleregister_item_recyclerview = (ImageButton) itemView.findViewById(R.id.repleregister_item_recyclerview);
    }
}

