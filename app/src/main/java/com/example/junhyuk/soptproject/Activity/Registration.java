package com.example.junhyuk.soptproject.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.junhyuk.soptproject.R;

public class Registration extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        findViewById(R.id.registration_button).setOnClickListener(this);

    }

    // 입력 버튼 클릭시 나오는 가입완료 팝업
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registration_button:
                new AlertDialog.Builder(this)
                        .setMessage("가입이 성공적으로 완료되었습니다")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                            }
                        })
                        .show();
                break;

        }
    }
}
