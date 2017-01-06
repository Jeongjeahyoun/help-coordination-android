package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiRegister.CodiRegisterActivity;
import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by EOM on 2015-08-20.
 */
public class Fragment3 extends Fragment {

    RecyclerView recyclerView;
    CodiMainAdapter adapter;
    ArrayList<CodiItemDatas> mDatas;
    LinearLayoutManager mLayoutManager;
    ImageButton coordi_writing;
    ImageView viewRipple;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);


        coordi_writing = (ImageButton)rootView.findViewById(R.id.coordi_writing);
        viewRipple = (ImageView)rootView.findViewById(R.id.viewRipple);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recylerView);

        mLayoutManager = new LinearLayoutManager(this.getActivity());

        //각 item의 크기가 일정할 경우 고정
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setHasFixedSize(true);

        mDatas = new ArrayList<CodiItemDatas>();
        mDatas.add(new CodiItemDatas("유나짱", R.mipmap.magic,"검정구두에 어울리는 면바지 브랜드 추천해주세요!"));
        mDatas.add(new CodiItemDatas("토르", R.mipmap.jean,"바지에 어울리는 상의좀 추천해주세요"));
        mDatas.add(new CodiItemDatas("곰돌이", R.mipmap.outer,"이 옷에 어울리는 바지좀 추천해주세요"));

        adapter = new CodiMainAdapter(mDatas);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        coordi_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CodiRegisterActivity.class);
                startActivity(intent);
            }
        });


/*
        viewRipple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivty(),RepleActivity.class);
                startActivity(intent);
            }
        });
        */

        return rootView;
    }
}
