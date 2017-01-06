package com.example.junhyuk.soptproject.Activity.P_My;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junhyuk.soptproject.R;

/**
 * Created by 김 유나 on 2016-12-30.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
     ImageView imageView;
     TextView nameView;
     TextView memoView;
    Button mRemoveButton;

    public ViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.image_MyCloset2);
        nameView =(TextView)itemView.findViewById(R.id.nameView2);
        memoView =(TextView)itemView.findViewById(R.id.memoView2);
       mRemoveButton = (Button) itemView.findViewById(R.id.deleteBtn);

    }
}


