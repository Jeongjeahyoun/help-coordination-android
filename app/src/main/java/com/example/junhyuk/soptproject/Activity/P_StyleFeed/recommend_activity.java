package com.example.junhyuk.soptproject.Activity.P_StyleFeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.junhyuk.soptproject.R;

/**
 * Created by JunHyuk on 2017-01-01.
 */

public class recommend_activity extends AppCompatActivity {


    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fr1_recommend);

        imageview = (ImageView)findViewById(R.id.img_recommend);
        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);

        Intent intent2 = getIntent();
        int index = intent2.getExtras().getInt("recom");

        if(index == 0)
            imageview.setBackgroundResource(R.drawable.photo_md1);
        else if(index == 1)
            imageview.setBackgroundResource(R.drawable.photo_md2);
        else
            imageview.setBackgroundResource(R.drawable.photo_md3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
