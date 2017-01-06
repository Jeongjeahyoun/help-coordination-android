package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiRegister;

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

public class CodiPage3 extends Fragment {

    ArrayList<Closet> closets;

    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.codiregister_fragment_page3, container, false);

        //Log.i("myTag", "test");

        recyclerView = (RecyclerView)view.findViewById(R.id.bottomRcView2);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        closets = new ArrayList<Closet>();

        Closet temp = new Closet();
        temp.setClothImage("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=185842819");
        closets.add(temp);
        temp = new Closet();
        temp.setClothImage("http://hawaiiseoulcdn.bunjang.net/product/34855057_1_1413295139_w320.jpg");
        closets.add(temp);
        temp = new Closet();
        temp.setClothImage("https://hell-bucket.s3.ap-northeast-2.amazonaws.com/1483246046460.png");
        closets.add(temp);
        temp = new Closet();
        temp.setClothImage("http://www.monki.com/Content/ProductContent/0390394001/0390394001_2_0.jpg");
        closets.add(temp);

        ImageAdapter2 adapter = new ImageAdapter2(closets, view.getContext(), ((CodiRegisterActivity)getActivity()));

        //Log.i("myTag", adapter.getItemCount() + " cnt");
        recyclerView.setAdapter(adapter);

        return view;
    }
}
