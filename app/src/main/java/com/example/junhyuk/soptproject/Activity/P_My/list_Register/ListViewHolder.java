package com.example.junhyuk.soptproject.Activity.P_My.list_Register;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junhyuk.soptproject.R;


/**
 * Created by 김 유나 on 2017-01-01.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView2;
    TextView nameView2;
    TextView memoView2;
    CheckBox checkBox;

    public ListViewHolder(View itemView) {
        super(itemView);

        imageView2 = (ImageView)itemView.findViewById(R.id.imageView);
        nameView2 =(TextView)itemView.findViewById(R.id.nameView);
        memoView2 =(TextView)itemView.findViewById(R.id.memoView);
        checkBox = (CheckBox)itemView.findViewById(R.id.checkbox);
        checkBox.setButtonDrawable(R.mipmap.check_box_default);


    }
}


