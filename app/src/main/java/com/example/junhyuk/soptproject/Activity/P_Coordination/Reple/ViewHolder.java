package com.example.junhyuk.soptproject.Activity.P_Coordination.Reple;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junhyuk.soptproject.R;


/**
 * Created by kh on 2016. 10. 24..
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    TextView rippleProfileName;
    ImageView rippleImage1,rippleImage2, rippleImage3, rippleImage4, rippleImage5, rippleImage6;
    TextView txt_ripple;
    TextView rippleLikeNum;




    public ViewHolder(View itemView) {
        super(itemView);

        rippleImage1 = (ImageView)itemView.findViewById(R.id.rippleImage1);
        rippleImage2 = (ImageView)itemView.findViewById(R.id.rippleImage2);
        rippleImage3 = (ImageView)itemView.findViewById(R.id.rippleImage3);
        rippleImage4 = (ImageView)itemView.findViewById(R.id.rippleImage4);
        rippleImage5 = (ImageView)itemView.findViewById(R.id.rippleImage5);
        rippleImage6 = (ImageView)itemView.findViewById(R.id.rippleImage6);
        rippleProfileName = (TextView)itemView.findViewById(R.id.rippleProfileName);
        txt_ripple =(TextView)itemView.findViewById(R.id.txt_ripple);
        rippleLikeNum =(TextView)itemView.findViewById(R.id.rippleLikeNum);

    }
}