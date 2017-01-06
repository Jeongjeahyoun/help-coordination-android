package com.example.junhyuk.soptproject.Activity.P_StyleFeed;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junhyuk.soptproject.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by JunHyuk on 2017-01-01.
 */

public class coordiking_activity extends AppCompatActivity {

    ImageView coordiking_image;
    TextView coordiking_nickname;
    TextView coordiking_content;
    TextView ranking_content;
    TextView mywriting_content;
    TextView mycoordi_content;

    Bitmap bitmap;
    Bitmap resized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fr1_coordiking);

        coordiking_image = (ImageView)findViewById(R.id.img_coordiking);
        coordiking_nickname = (TextView)findViewById(R.id.coordiking_nickname);
        coordiking_content = (TextView)findViewById(R.id.coordiking_content);
        ranking_content = (TextView)findViewById(R.id.ranking_content);
        mywriting_content = (TextView)findViewById(R.id.mywriting_content);
        mycoordi_content = (TextView)findViewById(R.id.mycoordi_content);

        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);

        int userId = getIntent().getExtras().getInt("userId");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String postUrl ="http://52.79.141.30:5000/profile/" + userId;
        (new HttpPingAsyncTask()).execute(postUrl);
    }



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

//            {
//                profile_id : 프로필 식별번호(기본키)
//                profile_nickname : 위 요청값과 동일
//                profile_image : 프로필 이미지
//                profile_message : 프로필 메세지
//                rank : 코디 랭킹
//                ask_num : 사용자가 쓴 의뢰글 수
//                codi_num : 사용자가 쓴 코디글 수
//            }
            try {
                jObject = jObject.getJSONObject("user_profile");

                new LoadImage(200, 200).execute(jObject.getString("profile_image"));
                coordiking_nickname.setText(jObject.getString("profile_nickname"));
                coordiking_content.setText(jObject.getString("profile_message"));
                ranking_content.setText(jObject.getString("rank"));
                mywriting_content.setText(jObject.getString("ask_num"));
                mycoordi_content.setText(jObject.getString("codi_num"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        private int reqWidth;
        private int reqHeight;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        private LoadImage(int reqWidth, int reqHeight) {
            this.reqWidth = reqWidth;
            this.reqHeight = reqHeight;
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
                coordiking_image.setImageBitmap(getRoundedBitmap(image));
            } else {
                Toast.makeText(getApplicationContext(), "이미지를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show();
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

