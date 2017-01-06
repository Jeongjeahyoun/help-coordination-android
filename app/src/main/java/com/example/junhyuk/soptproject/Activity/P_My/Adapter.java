package com.example.junhyuk.soptproject.Activity.P_My;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.junhyuk.soptproject.R;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 김 유나 on 2016-12-30.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<Item> itemDatas;
    ArrayList<Item> arSrc;
    Handler handler;

    //View.OnClickListener mOnClickListener;

    public Adapter(ArrayList<Item> itemDatas) {
        arSrc = itemDatas;
        this.itemDatas = itemDatas;
        //this.mOnClickListener = mOnClickListener;
    }


    public void setAdaper(ArrayList<Item> itemDatas) {
        arSrc = itemDatas;

        this.itemDatas = new ArrayList<Item>();
        this.itemDatas.addAll(arSrc);

        notifyDataSetChanged();
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);


        // itemView.setOnClickListener(mOnClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(arSrc.get(position).image);
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            holder.imageView.setImageBitmap(bm);
                        }
                    });

                } catch (Exception e) {

                }
            }
        });
        t.start();
        holder.nameView.setText(arSrc.get(position).name);
        holder.memoView.setText(arSrc.get(position).memo);
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemDatas.remove(position);
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {

        return (arSrc != null) ? arSrc.size() : 0;
    }

    public String getItem(int position) {
        return arSrc.get(position).name;
    }

    public long getItemId(int position) {
        return position;
    }
}



