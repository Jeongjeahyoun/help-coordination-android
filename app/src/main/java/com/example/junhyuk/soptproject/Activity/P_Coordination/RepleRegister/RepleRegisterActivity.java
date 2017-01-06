package com.example.junhyuk.soptproject.Activity.P_Coordination.RepleRegister;


import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.junhyuk.soptproject.Activity.P_Coordination.Reple.RepleActivity;
import com.example.junhyuk.soptproject.Model.Closet;
import com.example.junhyuk.soptproject.R;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;


public class RepleRegisterActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn_move_page1;
    ImageButton btn_move_page2;
    ImageButton btn_move_page3;
    ImageButton btn_move_page4;
    ImageButton btn_move_page5;
    ImageButton btn_move_page6;
    ImageButton btn_move_page7;

    ImageButton backButton;
    ImageButton btn_CompleteCodi;

    ImageView [] selectImage;
    LinkedList<Closet> selectImageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //풀스크린 만들어주는 코드 (액션바, 상태바 제거)
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getActionBar();
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reple_register);

        selectImage = new ImageView[6];
        setup();
        movePage1();
        selectImageUrl = new LinkedList<Closet>();
        //selectImageUrl = new LinkedList<Integer>();

        backButton = (ImageButton)findViewById(R.id.backButton);
        btn_CompleteCodi = (ImageButton)findViewById(R.id.btn_CompleteCodi);
        backButton.setOnClickListener((View.OnClickListener) this);


        // 이미지뷰 바인딩
        selectImage[0] = (ImageView) findViewById(R.id.image1);
        selectImage[1] = (ImageView) findViewById(R.id.image2);
        selectImage[2] = (ImageView) findViewById(R.id.image3);
        selectImage[3] = (ImageView) findViewById(R.id.image4);
        selectImage[4] = (ImageView) findViewById(R.id.image5);
        selectImage[5] = (ImageView) findViewById(R.id.image6);


        // 이미지뷰 클릭 리스너 정의
        for (int i =0; i<6; i++){
            selectImage[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "getTag : " + v.getTag());
                    Integer idx = (Integer)v.getTag();
                    if (idx !=null && selectImageUrl.size() > 0){
                        selectImageUrl.remove(((int)v.getTag()));// 이미지 누르면 원래데로 돌아오는 소스
                        for (ImageView imageView : selectImage)
                            imageView.setImageResource(R.mipmap.ic_launcher);
                        for (int i = 0; i < selectImageUrl.size(); i++) {
                            Picasso.with(getApplicationContext()).load(selectImageUrl.get(i).getClothImage()).into(selectImage[i]);
                            selectImage[i].setTag(i);
                        }
                    }
                }
            });
        }





    }

    @Override
    public void onClick(View v) {
        //다른 액티비티 호출
        //this는 현재 클래스
        Intent intent = new Intent(this, RepleActivity.class);
        startActivity(intent);

    }

    private void setup() {
        btn_move_page1 = (ImageButton) findViewById(R.id.btn_move_page1);
        btn_move_page2 = (ImageButton) findViewById(R.id.btn_move_page2);
        btn_move_page3 = (ImageButton) findViewById(R.id.btn_move_page3);
        btn_move_page4 = (ImageButton) findViewById(R.id.btn_move_page4);
        btn_move_page5 = (ImageButton) findViewById(R.id.btn_move_page5);
        btn_move_page6 = (ImageButton) findViewById(R.id.btn_move_page6);
        btn_move_page7 = (ImageButton) findViewById(R.id.btn_move_page7);


        btn_move_page1.setOnClickListener(myListener);
        btn_move_page2.setOnClickListener(myListener);
        btn_move_page3.setOnClickListener(myListener);
        btn_move_page4.setOnClickListener(myListener);
        btn_move_page5.setOnClickListener(myListener);
        btn_move_page6.setOnClickListener(myListener);
        btn_move_page7.setOnClickListener(myListener);

        btn_move_page1.setSelected(true);
    }


    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn_move_page1.setSelected(false);
            btn_move_page2.setSelected(false);
            btn_move_page3.setSelected(false);
            btn_move_page4.setSelected(false);
            btn_move_page5.setSelected(false);
            btn_move_page6.setSelected(false);
            btn_move_page7.setSelected(false);

            switch (v.getId()) {
                case R.id.btn_move_page1:
                    btn_move_page1.setSelected(true);
                    movePage1();
                    break;

                case R.id.btn_move_page2:
                    btn_move_page2.setSelected(true);
                    movePage2();
                    break;

                case R.id.btn_move_page3:
                    btn_move_page3.setSelected(true);
                    movePage3();
                    break;
                case R.id.btn_move_page4:
                    btn_move_page1.setSelected(true);
                    movePage1();
                    break;

                case R.id.btn_move_page5:
                    btn_move_page2.setSelected(true);
                    movePage2();
                    break;

                case R.id.btn_move_page6:
                    btn_move_page3.setSelected(true);
                    movePage3();
                    break;
                case R.id.btn_move_page7:
                    btn_move_page3.setSelected(true);
                    movePage3();
                    break;
            }
        }
    };

    public void movePage1() {
        Page1 page1 = new Page1();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page1);
        fragmentTransaction.commit();
    }

    public void movePage2() {
        Page2 page2 = new Page2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page2);
        fragmentTransaction.commit();
    }

    public void movePage3() {
        Page3 page3 = new Page3();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page3);
        fragmentTransaction.commit();
    }
    public void movePage4() {
        Page4 page4 = new Page4();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page4);
        fragmentTransaction.commit();
    }

    public void movePage5() {
        Page5 page5 = new Page5();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page5);
        fragmentTransaction.commit();
    }

    public void movePage6() {
        Page6 page6 = new Page6();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page6);
        fragmentTransaction.commit();
    }

    public void movePage7() {
        Page7 page7 = new Page7();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page, page7);
        fragmentTransaction.commit();
    }


    //프레그먼트 이미지 누르면 추가되는 소스
    public void onItemClick(Closet closet) {
        if (selectImageUrl.size() < 6) {
            selectImageUrl.add(closet);
            for (ImageView imageView : selectImage)
                imageView.setImageResource(R.mipmap.ic_launcher);
            for (int i = 0; i < selectImageUrl.size(); i++) {
                Picasso.with(this).load(selectImageUrl.get(i).getClothImage()).into(selectImage[i]);
                selectImage[i].setTag(i);
                Log.i("myTag", "setTag : " + selectImageUrl.getLast());
            }
        } else
            Toast.makeText(getApplicationContext(), "더 이상 이미지를 추가 할 수 없습니다.", Toast.LENGTH_LONG).show();

    }


}