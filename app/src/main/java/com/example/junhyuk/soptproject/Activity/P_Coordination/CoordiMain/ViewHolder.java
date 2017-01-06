package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junhyuk.soptproject.R;

/**
 * Created by jeongjeahyeon on 2017. 1. 3..
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView profile_nickname ;
    ImageView image;
    TextView content;




public ViewHolder(View itemView) {
        super(itemView);
        profile_nickname  = (TextView)itemView.findViewById(R.id.CodierNickname);
        image = (ImageView)itemView.findViewById(R.id.viewCodi);
        content =(TextView)itemView.findViewById(R.id.textCodi);

        }
}

