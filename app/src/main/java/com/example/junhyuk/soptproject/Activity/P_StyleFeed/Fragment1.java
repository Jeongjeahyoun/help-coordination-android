package com.example.junhyuk.soptproject.Activity.P_StyleFeed;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.junhyuk.soptproject.Activity.viewpager.ImgpagerAdapter;
import com.example.junhyuk.soptproject.R;
import com.matthewtamlin.sliding_intro_screen_library.DotIndicator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by EOM on 2015-08-20.
 */
public class Fragment1 extends Fragment  {
    /**
     //     * Count of index buttons. Default is 3
     //     */
    public static int countIndexes = 5;

    /**
     * ImageButton Layout
     */
    ImageButton buttonImage1;
    ImageButton buttonImage2;
    ImageButton buttonImage3;
    /**
     * Button Layout
     */
//    LinearLayout buttonLayout1;
//    LinearLayout buttonLayout2;
//    LinearLayout buttonLayout3;

    /**
     * MDimage Layout
     */
    ImageButton imageMD1;
    ImageButton imageMD2;
    ImageButton imageMD3;
    TextView textMD1;
    TextView textMD2;
    TextView textMD3;
    TextView countMD1;
    TextView countMD2;
    TextView countMD3;
    ImageView coordikingImage1;
    ImageView coordikingImage2;
    ImageView coordikingImage3;
    TextView coordikingNick1;
    TextView coordikingNick2;
    TextView coordikingNick3;

    /**
     * MDimage Layout
     */
    LinearLayout coordiitemLayout1;
    LinearLayout coordiitemLayout2;
    LinearLayout coordiitemLayout3;

    /**
     * Index button images
     */
    ImageView[] indexButtons1;
    ImageView[] indexButtons2;
    ImageView[] indexButtons3;

    /**
     * Views for the Flipper
     */
    View[] views1;
    View[] views2;
    View[] views3;

    /**
     * Flipper instance
     */
//    ViewFlipper flipper1;
    ViewFlipper flipper2;
    ViewFlipper flipper3;

    /**
     * X coordinate for touch down
     */
    float downX;

    /**
     * X coordinate for touch up
     */
    float upX;

    /**
     * Current index
     */
    int currentIndex1 = 0;
    int currentIndex2 = 0;
    int currentIndex3 = 0;

    ScrollView scrollView;


    ArrayList<String> imgUrl;
    ViewPager pager;
    ImgpagerAdapter adapter;

    DotIndicator indicator;

    JSONArray kingsArray = new JSONArray();
    JSONArray mdItemsArray = new JSONArray();
    JSONArray weekArray = new JSONArray();

    int userId;
    String linkMD1;
    String linkMD2;
    String linkMD3;

    Bitmap bitmap;
    Bitmap resized;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fr1, container, false);

        imageMD1 = (ImageButton) rootView.findViewById(R.id.img_MD1);
        imageMD2 = (ImageButton) rootView.findViewById(R.id.img_MD2);
        imageMD3 = (ImageButton) rootView.findViewById(R.id.img_MD3);
        textMD1 = (TextView) rootView.findViewById(R.id.text_MD1);
        textMD2 = (TextView) rootView.findViewById(R.id.text_MD2);
        textMD3 = (TextView) rootView.findViewById(R.id.text_MD3);
        countMD1 = (TextView) rootView.findViewById(R.id.count_MD1);
        countMD2 = (TextView) rootView.findViewById(R.id.count_MD2);
        countMD3 = (TextView) rootView.findViewById(R.id.count_MD3);
        coordikingImage1 = (ImageView) rootView.findViewById(R.id.coordiking_image1);
        coordikingImage2 = (ImageView) rootView.findViewById(R.id.coordiking_image2);
        coordikingImage3 = (ImageView) rootView.findViewById(R.id.coordiking_image3);
        coordikingNick1 = (TextView) rootView.findViewById(R.id.coordiking_nick1);
        coordikingNick2 = (TextView) rootView.findViewById(R.id.coordiking_nick2);
        coordikingNick3 = (TextView) rootView.findViewById(R.id.coordiking_nick3);


        coordiitemLayout1 = (LinearLayout) rootView.findViewById(R.id.coordiitemLayout1);
        coordiitemLayout2 = (LinearLayout) rootView.findViewById(R.id.coordiitemLayout2);
        coordiitemLayout3 = (LinearLayout) rootView.findViewById(R.id.coordiitemLayout3);
        scrollView = (ScrollView) rootView.findViewById(R.id.scrollView);
        pager = (ViewPager)rootView.findViewById(R.id.pager);
        indicator = (DotIndicator)rootView.findViewById(R.id.pager_indicator);



   //         String postUrl = "http://dba.stackexchange.com/questions/13703/get-the-rank-of-a-user-in-a-score-table/main/";
        String postUrl ="http://52.79.141.30:5000/main";
        (new HttpPingAsyncTask()).execute(postUrl);

        imgUrl = new ArrayList<>();

        /**
         * 서버에서 받아온 이미지 url 넣어서 보내주면 자동으로 사진 넣어줄꺼야
         */
       imgUrl.add("https://s3.ap-northeast-2.amazonaws.com/hell-bucket/1483704246532.jpg");
       imgUrl.add("https://s3.ap-northeast-2.amazonaws.com/hell-bucket/1483704320773.jpg");
       imgUrl.add("https://s3.ap-northeast-2.amazonaws.com/hell-bucket/1483704382404.jpg");

        adapter= new ImgpagerAdapter(getActivity().getLayoutInflater(),imgUrl,mOnClickListener);

        //ViewPager에 Adapter 설정
        pager.setAdapter(adapter);

        /**
         * 도트 색 지정
         */
        indicator.setSelectedDotColor( Color.parseColor( "#927DFF" ) );
        indicator.setUnselectedDotColor( Color.parseColor( "#727272" ) );


        /**
         * indicator 초기화
         */
        indicator.setNumberOfItems( imgUrl.size());

        /**
         * 스크롤 등으로 다음 페이지로 넘어갈 때 도트도 옮김
         */
        pager.addOnPageChangeListener( new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels )
            {

            }

            @Override
            public void onPageSelected( int position )
            {
                indicator.setSelectedItem( pager.getCurrentItem(), true );
            }

            @Override
            public void onPageScrollStateChanged( int state )
            {

            }

        } );

        coordiitemLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),coordiking_activity.class);
                try {
                    intent2.putExtra("userId", kingsArray.getJSONObject(0).getInt("user_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent2);
            }
        });
        coordiitemLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),coordiking_activity.class);
                try {
                    intent2.putExtra("userId", kingsArray.getJSONObject(1).getInt("user_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent2);
                }
        });
        coordiitemLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),coordiking_activity.class);
                try {
                    intent2.putExtra("userId", kingsArray.getJSONObject(2).getInt("user_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent2);
            }
        });

        imageMD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkMD1));
                startActivity(intent);
            }
        });
        imageMD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkMD2));
                startActivity(intent);
            }
        });
        imageMD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkMD3));
                startActivity(intent);
            }
        });

        return rootView;
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id = v.getTag(R.string.img_tag).toString();
            Intent intent1 = new Intent(getActivity(), thisweek_activity.class);
            intent1.putExtra("index", Integer.valueOf(id));
            startActivity(intent1);
        }
    };

    class HttpPingAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(urls[0]);
                HttpResponse response = client.execute(get);
                HttpEntity resEntity = response.getEntity();

                String res = "";
                if(resEntity != null){
                    res = EntityUtils.toString(resEntity);
                }
                return res;
            } catch (Exception e) {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String res) {
            super.onPostExecute(res);

            JSONObject jObject = null;
            try {
                jObject = new JSONObject(res);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.e("tag", String.valueOf(jObject));

            try {
                kingsArray = jObject.getJSONArray("kings");
                mdItemsArray = jObject.getJSONArray("MD_items");
                weekArray = jObject.getJSONArray("week");

                coordikingNick1.setText(kingsArray.getJSONObject(0).getString("profile_nickname"));
                coordikingNick2.setText(kingsArray.getJSONObject(1).getString("profile_nickname"));
                coordikingNick3.setText(kingsArray.getJSONObject(2).getString("profile_nickname"));

                new LoadImage(200, 200, 1, 1).execute(kingsArray.getJSONObject(0).getString("profile_image"));
                new LoadImage(200, 200, 2, 1).execute(kingsArray.getJSONObject(1).getString("profile_image"));
                new LoadImage(200, 200, 3, 1).execute(kingsArray.getJSONObject(2).getString("profile_image"));

                textMD1.setText(mdItemsArray.getJSONObject(0).getString("image_name"));
                textMD2.setText(mdItemsArray.getJSONObject(1).getString("image_name"));
                textMD3.setText(mdItemsArray.getJSONObject(2).getString("image_name"));

                new LoadImage(416, 452, 1, 2).execute(mdItemsArray.getJSONObject(0).getString("image_url"));
                new LoadImage(416, 452, 2, 2).execute(mdItemsArray.getJSONObject(1).getString("image_url"));
                new LoadImage(416, 452, 3, 2).execute(mdItemsArray.getJSONObject(2).getString("image_url"));

                countMD1.setText(mdItemsArray.getJSONObject(0).getString("price"));
                countMD2.setText(mdItemsArray.getJSONObject(1).getString("price"));
                countMD3.setText(mdItemsArray.getJSONObject(2).getString("price"));

                linkMD1 = mdItemsArray.getJSONObject(0).getString("link");
                linkMD2 = mdItemsArray.getJSONObject(1).getString("link");
                linkMD3 = mdItemsArray.getJSONObject(2).getString("link");
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        private int reqWidth;
        private int reqHeight;
        private int imageIndex;
        private int menuIndex;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        private LoadImage(int reqWidth, int reqHeight, int imageIndex, int menuIndex) {
            this.reqWidth = reqWidth;
            this.reqHeight = reqHeight;
            this.imageIndex = imageIndex;
            this.menuIndex = menuIndex;
        }

        protected Bitmap doInBackground(String... args) {
            try {
                // First decode with inJustDecodeBounds=true to check dimensions
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent(), null, options);

                // Calculate inSampleSize
                options.inSampleSize = 4;

                // Decode bitmap with inSampleSize set
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent(), null, options);

                resized = Bitmap.createScaledBitmap(bitmap, reqWidth, reqHeight, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resized;
        }

        protected void onPostExecute(Bitmap image) {
            if (image != null) {
                if(menuIndex == 1) {
                    if (imageIndex == 1) {
                        coordikingImage1.setImageBitmap(getRoundedBitmap(image));
                    } else if (imageIndex == 2) {
                        coordikingImage2.setImageBitmap(getRoundedBitmap(image));
                    } else if (imageIndex == 3) {
                        coordikingImage3.setImageBitmap(getRoundedBitmap(image));
                    }
                } else if(menuIndex == 2){
                    if (imageIndex == 1) {
                        imageMD1.setImageBitmap(image);
                    } else if (imageIndex == 2) {
                        imageMD2.setImageBitmap(image);
                    } else if (imageIndex == 3) {
                        imageMD3.setImageBitmap(image);
                    }
                }
            } else {
                Toast.makeText(getContext(), "이미지를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public static Bitmap getRoundedBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.GRAY;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();

        return output;
    }

}
