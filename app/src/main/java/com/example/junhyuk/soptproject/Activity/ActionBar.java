package com.example.junhyuk.soptproject.Activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JunHyuk on 2017-01-04.
 */

public class ActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ActionBar에 타이틀 변경
        getSupportActionBar().setTitle("TEST");
        // ActionBar의 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
    }
}
