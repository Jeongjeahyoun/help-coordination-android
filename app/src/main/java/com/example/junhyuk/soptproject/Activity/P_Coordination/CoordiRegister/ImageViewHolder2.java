package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiRegister;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.junhyuk.soptproject.R;

/**
 * Created by jeongjeahyeon on 2017. 1. 5..
 */

public class ImageViewHolder2 extends RecyclerView.ViewHolder {


    public ImageButton codiregister_item_recyclerview;

    public ImageViewHolder2(View itemView) {
        super(itemView);
        codiregister_item_recyclerview = (ImageButton) itemView.findViewById(R.id.codiregister_item_recyclerview);
    }
}

