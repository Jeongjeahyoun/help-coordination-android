package com.example.junhyuk.soptproject.Activity.P_Setup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.junhyuk.soptproject.R;

/**
 * Created by JunHyuk on 2017-01-04.
 */

public class MainSetup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_main);

        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);


        RelativeLayout noticeButton = (RelativeLayout)findViewById(R.id.notice_button);
        RelativeLayout versionButton = (RelativeLayout)findViewById(R.id.version_button);
        RelativeLayout alarmButton = (RelativeLayout)findViewById(R.id.alarm_button);
        RelativeLayout screenButton = (RelativeLayout)findViewById(R.id.screen_button);
        RelativeLayout othersButton = (RelativeLayout)findViewById(R.id.others_button);

        Button noticeButton1 = (Button)findViewById(R.id.notice_button1);
        Button versionButton1 = (Button)findViewById(R.id.version_button1);
        Button alarmButton1 = (Button)findViewById(R.id.alarm_button1);
        Button screenButton1 = (Button)findViewById(R.id.screen_button1);
        Button othersButton1 = (Button)findViewById(R.id.others_button1);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSetup.this, Notice.class);
                startActivity(intent);

            }
        });

        versionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Version.class);
                startActivity(intent);
            }
        });

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Alarm.class);
                startActivity(intent);
            }
        });

        screenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Screen.class);
                startActivity(intent);
            }
        });

        othersButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                    Intent intent = new Intent(MainSetup.this, Others.class);
                    startActivity(intent);
                }
        });


        noticeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSetup.this, Notice.class);
                startActivity(intent);

            }
        });

        versionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Version.class);
                startActivity(intent);
            }
        });

        alarmButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Alarm.class);
                startActivity(intent);
            }
        });

        screenButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Screen.class);
                startActivity(intent);
            }
        });

        othersButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainSetup.this, Others.class);
                startActivity(intent);
            }
        });
    }
}

