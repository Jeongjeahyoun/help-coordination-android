package com.example.junhyuk.soptproject.Activity.P_Setup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.junhyuk.soptproject.R;

/**
 * Created by JunHyuk on 2017-01-04.
 */

public class Screen  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_screen);

        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}