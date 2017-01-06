package com.example.junhyuk.soptproject.Activity.P_StyleFeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junhyuk.soptproject.R;

/**
 * Created by JunHyuk on 2017-01-01.
 */

public class thisweek_activity  extends AppCompatActivity {

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fr1_thisweek);

        int img[] = {
                R.drawable.img_outer,R.drawable.img_knit,R.drawable.img_muffler,
                R.drawable.img_bag,R.drawable.img_jean,R.drawable.img_shoes
        };

        String text[] = {
                "1","2","3","4","5","6"
        };

        MyAdapter adapter = new MyAdapter(getApplicationContext(),
                R.layout.thisweekd_gridview_item, img, text);

        GridView gv = (GridView)findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        // GridView 아이템을 클릭하면 상단 텍스트뷰에 position 출력
        // JAVA8 에 등장한 lambda expression 으로 구현했습니다. 코드가 많이 간결해지네요
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),position+"번 클릭",Toast.LENGTH_LONG).show();
            }
        });




        imageview = (ImageView)findViewById(R.id.img_coordi);
        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);

        Intent intent1 = getIntent();
        int index = intent1.getExtras().getInt("index");

        if(index == 0)
            imageview.setBackgroundResource(R.drawable.img_thisweek1);
        else if(index == 1)
            imageview.setBackgroundResource(R.drawable.img_thisweek2);
        else if(index == 2)
            imageview.setBackgroundResource(R.drawable.img_thisweek3);
        else if(index == 3)
            imageview.setBackgroundResource(R.drawable.img_thisweek4);
        else
              imageview.setBackgroundResource(R.drawable.img_thisweek5);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

/*extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fr1_thisweek, container, false);

        return rootView;
    }

}
*/


class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    int img[];
    String text[];
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, int[] img, String[] text) {
        this.context = context;
        this.layout = layout;
        this.img = img;
        this.text = text;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = inf.inflate(layout, null);

        ImageView iv = (ImageView)convertView.findViewById(R.id.imgView);
        TextView tv = (TextView)convertView.findViewById(R.id.textView);



        iv.setImageResource(img[position]);
        tv.setText(text[position]);

        return convertView;
    }
}
