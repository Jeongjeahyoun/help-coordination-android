package com.example.junhyuk.soptproject.Activity.P_Coordination.RepleRegister;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.Model.Closet;
import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by jeongjeahyeon on 2017. 1. 5..
 */

public class Page2 extends Fragment {

    ArrayList<Closet> closets;

    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    //ImageView [] imageViews;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.repleregister_fragment_page2, container, false);
        //imageViews = new ImageView[6];

        //Log.i("myTag", "test");

        recyclerView = (RecyclerView)view.findViewById(R.id.bottomRcView);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        closets = new ArrayList<Closet>();

        Closet temp = new Closet();
        temp.setClothImage("https://hell-bucket.s3.ap-northeast-2.amazonaws.com/1483100875700.jpg");
        closets.add(temp);
        temp = new Closet();
        temp.setClothImage("https://hell-bucket.s3.ap-northeast-2.amazonaws.com/1483244949246.png");
        closets.add(temp);
        temp = new Closet();
        temp.setClothImage("https://hell-bucket.s3.ap-northeast-2.amazonaws.com/1483244976550.png");
        closets.add(temp);


        ImageAdapter adapter = new ImageAdapter(closets, view.getContext(), ((RepleRegisterActivity)getActivity()));

        //Log.i("myTag", adapter.getItemCount() + " cnt");
        recyclerView.setAdapter(adapter);

        return view;
    }
}