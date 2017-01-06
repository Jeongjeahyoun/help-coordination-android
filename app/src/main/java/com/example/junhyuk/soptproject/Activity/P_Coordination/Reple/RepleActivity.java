package com.example.junhyuk.soptproject.Activity.P_Coordination.Reple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.junhyuk.soptproject.R;

import java.util.ArrayList;

public class RepleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ItemDatas> mDatas;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reple);
/*
        new MyClosetServiceBuilder().getService().getCloset("nickname").enqueue(new Callback<ArrayList<Codi>>() {
            @Override
            public void onResponse(Call<ArrayList<Codi>> call, Response<ArrayList<Codi>> response) {
                // 정상 응답 들어왔을때 200번대
                ArrayList<Codi> closets = response.body();
                for(int i = 0; i<closets.size(); i++){
                    Log.i("TAG", closets.get(i).getAsker());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Codi>> call, Throwable t) {
                // 그 외 실패했을때

            }
        });
*/


        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //각 item의 크기가 일정할 경우 고정
        recyclerView.setHasFixedSize(true);


        //TODO LayoutManager 초기화
        // layoutManager 설정
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        mDatas = new ArrayList<ItemDatas>();
        mDatas.add(new ItemDatas("asker1", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,"content1","1"));
        mDatas.add(new ItemDatas("asker2", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,"content2","2"));
        mDatas.add(new ItemDatas("asker3", R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,"content3","3"));

        RepleAdapter adapter = new RepleAdapter(mDatas,clickEvent);


        recyclerView.setAdapter(adapter);
    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            String temp = mDatas.get(itemPosition).txt_ripple;
            Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();
        }
    };

}