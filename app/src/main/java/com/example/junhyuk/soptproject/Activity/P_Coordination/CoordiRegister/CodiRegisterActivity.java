package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiRegister;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.junhyuk.soptproject.Model.Closet;
import com.example.junhyuk.soptproject.R;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class CodiRegisterActivity extends AppCompatActivity {
    ImageButton btn_move_page1;
    ImageButton btn_move_page2;
    ImageButton btn_move_page3;
    ImageButton btn_move_page4;
    ImageButton btn_move_page5;
    ImageButton btn_move_page6;
    ImageButton btn_move_page7;

    ImageButton backButton;
    ImageButton btn_CompleteCodi;

    ImageView[] selectImage;
    LinkedList<Closet> selectImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codi_register);


        selectImage = new ImageView[6];
        setup();
        movePage1();
        selectImageUrl = new LinkedList<Closet>();
        //selectImageUrl = new LinkedList<Integer>();



        backButton = (ImageButton) findViewById(R.id.backButton);
        btn_CompleteCodi = (ImageButton) findViewById(R.id.btn_CompleteCodi);


        btn_CompleteCodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"글 등록 완료",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 이미지뷰 바인딩
        selectImage[0] = (ImageView) findViewById(R.id.image1);




        // 이미지뷰 클릭 리스너 정의
        for (int i = 0; i < 1; i++) {
            selectImage[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "getTag : " + v.getTag());
                    Integer idx2 = (Integer) v.getTag();
                    if (idx2 != null && selectImageUrl.size() > 0) {
                        selectImageUrl.remove(((int) v.getTag()));// 이미지 누르면 원래데로 돌아오는 소스
                        for (ImageView imageView : selectImage)
 //                            imageView.setImageResource(R.mipmap.ic_launcher);
                        for (int i = 0; i < selectImageUrl.size(); i++) {
                            Picasso.with(getApplicationContext()).load(selectImageUrl.get(i).getClothImage()).into(selectImage[i]);
                            selectImage[i].setTag(i);
                        }
                    }
                }
            });
        }


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
                    movePage4();
                    break;

                case R.id.btn_move_page5:
                    btn_move_page2.setSelected(true);
                    movePage5();
                    break;

                case R.id.btn_move_page6:
                    btn_move_page3.setSelected(true);
                    movePage6();
                    break;
                case R.id.btn_move_page7:
                    btn_move_page3.setSelected(true);
                    movePage7();
                    break;
            }
        }
    };

    public void movePage1() {
        CodiPage1 page1 = new CodiPage1();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page1);
        fragmentTransaction.commit();
    }

    public void movePage2() {
        CodiPage2 page2 = new CodiPage2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page2);
        fragmentTransaction.commit();
    }

    public void movePage3() {
        CodiPage3 page3 = new CodiPage3();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page3);
        fragmentTransaction.commit();
    }

    public void movePage4() {
        CodiPage4 page4 = new CodiPage4();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page4);
        fragmentTransaction.commit();
    }

    public void movePage5() {
        CodiPage5 page5 = new CodiPage5();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page5);
        fragmentTransaction.commit();
    }

    public void movePage6() {
        CodiPage6 page6 = new CodiPage6();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page6);
        fragmentTransaction.commit();
    }

    public void movePage7() {
        CodiPage7 page7 = new CodiPage7();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_page2, page7);
        fragmentTransaction.commit();
    }


    //프레그먼트 이미지 누르면 추가되는 소스
    public void onItemClick(Closet closet) {
        if (selectImageUrl.size() < 1) {
            selectImageUrl.add(closet);
            for (ImageView imageView : selectImage) {
   //             imageView.setImageResource(R.mipmap.ic_launcher);
            }
            for (int i = 0; i < selectImageUrl.size(); i++) {
                Picasso.with(this).load(selectImageUrl.get(i).getClothImage()).into(selectImage[i]);
                selectImage[i].setTag(i);
                Log.i("myTag", "setTag : " + selectImageUrl.getLast());
            }
        } else
            Toast.makeText(getApplicationContext(), "더 이상 이미지를 추가 할 수 없습니다.", Toast.LENGTH_LONG).show();

    }
}
