package com.example.junhyuk.soptproject.Activity.P_My;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.junhyuk.soptproject.R;

public class Page1 extends Fragment {
    Button btn_move_page1_list1;
    Button btn_move_page1_list2;
    Button btn_move_page1_list3;
    Button btn_move_page1_list4;
    Button btn_move_page1_list5;
    Button btn_move_page1_list6;
    Button btn_move_page1_list7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1, container, false);


        btn_move_page1_list1.setOnClickListener(myListener);
        btn_move_page1_list2.setOnClickListener(myListener);
        btn_move_page1_list3.setOnClickListener(myListener);
        btn_move_page1_list4.setOnClickListener(myListener);
        btn_move_page1_list5.setOnClickListener(myListener);
        btn_move_page1_list6.setOnClickListener(myListener);
        btn_move_page1_list7.setOnClickListener(myListener);

        btn_move_page1_list1.setSelected(true);
        return view;

    }


    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn_move_page1_list1.setSelected(false);
            btn_move_page1_list2.setSelected(false);
            btn_move_page1_list3.setSelected(false);
            btn_move_page1_list4.setSelected(false);


        }
    };

}