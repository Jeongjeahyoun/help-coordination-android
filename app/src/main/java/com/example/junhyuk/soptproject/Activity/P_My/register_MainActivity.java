package com.example.junhyuk.soptproject.Activity.P_My;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.junhyuk.soptproject.R;

public class register_MainActivity extends Fragment {

    Button btn_move_page1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fr2, container, false);

        movePage1();

        return view;

    }

    public void movePage1() {
        Page1 page1 = new Page1();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_page, page1);
        fragmentTransaction.commit();
    }

}

// private final long FINSH_INTERVAL_TIME = 2000;
//    private long backPressedTime = 0;
//
//    Button btn_move_page1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fr2);
//
//
//
//    }
//
//
//



