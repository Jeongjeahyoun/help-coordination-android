package com.example.junhyuk.soptproject.Activity.viewpager;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

/**
 * Created by kh on 2016. 10. 20..
 */
public class ImgpagerAdapter extends PagerAdapter {
    private View.OnClickListener mOnClickListener;

    private ArrayList<String> imgUrlDatas;
    LayoutInflater inflater;

    public ImgpagerAdapter(LayoutInflater inflater, ArrayList<String> datas,
                           View.OnClickListener mOnClickListener) {

        this.inflater=inflater;
        this.imgUrlDatas = datas;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imgUrlDatas.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.viewpage_img, null);
        ImageView imgView= (ImageView)view.findViewById(R.id.viewpageImg);

        /**
         * 임시 이미지
         */
//        Log.i("myTag","position " + imgUrlDatas.get(position));


        Log.i("myTag","ggg");

        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(view.getContext())
                .load(imgUrlDatas.get(position))
                .into(imgView);


        //ViewPager에 만들어 낸 View 추가
        container.addView(view);

        imgView.setTag(R.string.img_tag, position);
        imgView.setOnClickListener(mOnClickListener);

        //Image가 세팅된 View를 리턴
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        //ViewPager에서 보이지 않는 View는 제거
        //세번째 파라미터가 View 객체 이지만 데이터 타입이 Object여서 형변환 실시
        container.removeView((View)object);

    }

    //instantiateItem() 메소드에서 리턴된 Ojbect가 View가  맞는지 확인하는 메소드
    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v==obj;
    }

}