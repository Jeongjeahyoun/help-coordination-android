package com.example.junhyuk.soptproject.Activity.P_My.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.junhyuk.soptproject.Activity.P_My.model.RegiseterFragment1;
import com.example.junhyuk.soptproject.Activity.P_My.model.RegiseterFragment2;

/**
 * Created by kh on 2016. 12. 7..
 */
public class PagerAdapter extends FragmentStatePagerAdapter {


    public Fragment[] fragments = new Fragment[2];

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new RegiseterFragment1();
        fragments[1] = new RegiseterFragment2();

    }
    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }
    public int getCount() {
        return fragments.length;
    }


}
