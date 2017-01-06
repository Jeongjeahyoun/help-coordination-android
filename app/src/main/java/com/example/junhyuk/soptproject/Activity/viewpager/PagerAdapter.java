package com.example.junhyuk.soptproject.Activity.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain.Fragment3;
import com.example.junhyuk.soptproject.Activity.P_My.Fragment2;
import com.example.junhyuk.soptproject.Activity.P_Profile.Fragment4;
import com.example.junhyuk.soptproject.Activity.P_StyleFeed.Fragment1;

/**
 * Created by kh on 2016. 12. 7..
 */
public class PagerAdapter extends FragmentStatePagerAdapter {


    public Fragment[] fragments = new Fragment[4];
    String user_id;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        this.user_id = user_id;
        fragments[0] = new Fragment1();
        fragments[1] = new Fragment2();
        fragments[2] = new Fragment3();
        fragments[3] = new Fragment4();


    }
    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }
    public int getCount() {
        return fragments.length;
    }


}
