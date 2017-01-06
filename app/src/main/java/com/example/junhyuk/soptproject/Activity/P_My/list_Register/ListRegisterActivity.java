package com.example.junhyuk.soptproject.Activity.P_My.list_Register;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;


public class ListRegisterActivity extends Activity {

    RecyclerView recyclerView;
    //ImageButton addBtn;

    LinearLayoutManager mLayoutManager;
    ListAdapter adapter;
    ArrayList<ListItem> itemDatas;

    Button btn_ClosetBack;
    Button completeBtn;

    Context context;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment_list1);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        btn_ClosetBack = (Button) findViewById(R.id.btn_ClosetBack);
        completeBtn = (Button) findViewById(R.id.completeBtn);

       btn_ClosetBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
           finish();

           }


       });


        //addBtn = (ImageButton) rootView.findViewById(R.id.addBtn);

//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
//
//                alertDialogBuilder
//                        .setMessage("옷을 추가할 방법을 선택해주세요")
//                        .setCancelable(false)
//                        .setPositiveButton("직접 추가",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Intent intent = new Intent(getActivity().getApplication(), RegisterActivity.class);
//                                        startActivity(intent);
//                                    }
//                                }
//                        )
//                        .setNegativeButton("리스트 추가",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        moveListRegister2();
//                                    }
//
//
//                                });
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();
//            }
//        });
        recyclerView.setHasFixedSize(true);


        itemDatas = new ArrayList<ListItem>();
        itemDatas.add(new ListItem(R.drawable.gallery, "나이키 후드티", "박시한 스타일"));
        itemDatas.add(new ListItem(R.drawable.gallery, "나이키 후드티", "박시한 스타일"));
        itemDatas.add(new ListItem(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
        itemDatas.add(new ListItem(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));

        adapter = new ListAdapter(itemDatas);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}