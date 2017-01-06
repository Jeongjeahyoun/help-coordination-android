package com.example.junhyuk.soptproject.Activity.P_My.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.Activity.P_My.Adapter;
import com.example.junhyuk.soptproject.Activity.P_My.Item;
import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by kh on 2017. 1. 3..
 */

public class RegiseterFragment1 extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Item> itemDatas;

    LinearLayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));

        recyclerView.setHasFixedSize(true);

        itemDatas = new ArrayList<Item>();
//        itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//        itemDatas.add(new Item(R.drawable.gallery, "나이키 후드티", "박시한 스타일"));
//        itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//        itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//        itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//        itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));

        adapter = new Adapter(itemDatas);
        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


        return view;
    }
}
