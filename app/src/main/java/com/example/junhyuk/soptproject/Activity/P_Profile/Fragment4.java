package com.example.junhyuk.soptproject.Activity.P_Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.junhyuk.soptproject.R;

/**
 * Created by JunHyuk on 2016-12-31.
 */

public class Fragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);

        Button profile_change_Btn;


        profile_change_Btn = (Button)rootView.findViewById(R.id.profile_change_Btn);
        profile_change_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpPhotoActivity.class);
                Toast.makeText(getActivity(),"ssd",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        return rootView;
    }
}

/*
public class Fragment4 extends AppCompatActivity {

    Button profile_change_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fr4);

        profile_change_Btn = (Button)findViewById(R.id.profile_change_Btn);
        profile_change_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpPhotoActivity.class);
                Toast.makeText(getApplicationContext(),"ssd",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}*/