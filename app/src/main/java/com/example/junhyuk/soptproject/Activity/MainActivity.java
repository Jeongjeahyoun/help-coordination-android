package com.example.junhyuk.soptproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain.Fragment3;
import com.example.junhyuk.soptproject.Activity.P_My.register_MainActivity;
import com.example.junhyuk.soptproject.Activity.P_Profile.Fragment4;
import com.example.junhyuk.soptproject.Activity.P_Setup.MainSetup;
import com.example.junhyuk.soptproject.Activity.P_StyleFeed.Fragment1;
import com.example.junhyuk.soptproject.Activity.viewpager.CustomViewPager;
import com.example.junhyuk.soptproject.Activity.viewpager.PagerAdapter;
import com.example.junhyuk.soptproject.R;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    Fragment1 fragment1;
    // Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    register_MainActivity fragment2;
    ImageButton button_setup;



    CustomViewPager viewPager;
    com.example.junhyuk.soptproject.Activity.viewpager.PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent(getApplicationContext(),Splash.class);
        startActivity(intent1);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);



        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        viewPager.setPagingDisabled();

        View view1 = getLayoutInflater().inflate(R.layout.img_stylefeed, null);
        View view2 = getLayoutInflater().inflate(R.layout.img_my, null);
        View view3 = getLayoutInflater().inflate(R.layout.img_coordi, null);
        View view4 = getLayoutInflater().inflate(R.layout.img_profile, null);

        final View view5 = getLayoutInflater().inflate(R.layout.img_stylefeed, null);
        final View view6 = getLayoutInflater().inflate(R.layout.img_my, null);
        final View view7 = getLayoutInflater().inflate(R.layout.img_coordi, null);
        final View view8 = getLayoutInflater().inflate(R.layout.img_profile, null);


        view1.findViewById(R.id.icon).setBackgroundResource(R.mipmap.style_default_menu);
        view2.findViewById(R.id.icon).setBackgroundResource(R.mipmap.mycloset_default_menu);
        view3.findViewById(R.id.icon).setBackgroundResource(R.mipmap.cody_default_menu);
        view4.findViewById(R.id.icon).setBackgroundResource(R.mipmap.profile_default_menu);

        view5.findViewById(R.id.icon).setBackgroundResource(R.mipmap.style_click_menu);
        view6.findViewById(R.id.icon).setBackgroundResource(R.mipmap.mycloset_click_menu);
        view7.findViewById(R.id.icon).setBackgroundResource(R.mipmap.cody_click_menu);
        view8.findViewById(R.id.icon).setBackgroundResource(R.mipmap.profile_click_menu);



        button_setup = (ImageButton)findViewById(R.id.button_setup);

        button_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,MainSetup.class);
                startActivity(intent1);
            }
        });



//        fragment1 = new Fragment1();
//        //  fragment2 = new Fragment2();
//        fragment3 = new Fragment3();
//        fragment4 = new Fragment4();
//        fragment2 = new register_MainActivity();
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
//
//
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        final TabLayout.Tab tab1 = tabs.newTab().setCustomView(view5);
        tabs.addTab(tab1);

        tabs.addTab(tabs.newTab().setCustomView(view2));
        tabs.addTab(tabs.newTab().setCustomView(view3));
        tabs.addTab(tabs.newTab().setCustomView(view4));


        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);


                viewPager.setCurrentItem(tab.getPosition());

                LinearLayout linearLayout = (LinearLayout) tab.getCustomView();

                if(position == 0) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.style_click_menu);
                    tab.setCustomView(linearLayout);
                    button_setup.setVisibility(View.GONE);
                }
                if(position == 1) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.mycloset_click_menu);
                    tab.setCustomView(linearLayout);
                    button_setup.setVisibility(View.GONE);
                }
                if(position == 2) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.cody_click_menu);
                    tab.setCustomView(linearLayout);
                    button_setup.setVisibility(View.GONE);
                }
                if(position == 3) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.profile_click_menu);
                    tab.setCustomView(linearLayout);
                    button_setup.setVisibility(View.VISIBLE);
                }
//
//                Fragment selected = null;
//                if (position == 0) {
//                    selected = fragment1;
//                } else if (position == 1) {
//                    selected = fragment2;
//                } else if (position == 2) {
//                    selected = fragment3;
//                } else if (position == 3) {
//                    selected = fragment4;
//                }
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                LinearLayout linearLayout = (LinearLayout) tab.getCustomView();

                if(position == 0) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.style_default_menu);
                    tab.setCustomView(linearLayout);
                }
                if(position == 1) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.mycloset_default_menu);
                    tab.setCustomView(linearLayout);
                }
                if(position == 2) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.cody_default_menu);
                    tab.setCustomView(linearLayout);
                }
                if(position == 3) {
                    linearLayout.findViewById(R.id.icon).setBackgroundResource(R.mipmap.profile_default_menu);
                    tab.setCustomView(linearLayout);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

    }

}
