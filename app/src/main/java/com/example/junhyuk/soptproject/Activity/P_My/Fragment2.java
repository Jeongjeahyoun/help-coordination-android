package com.example.junhyuk.soptproject.Activity.P_My;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.junhyuk.soptproject.Activity.P_My.list_Register.ListRegisterActivity;
import com.example.junhyuk.soptproject.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by EOM on 2015-08-20.
 */
public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    ImageButton addBtn;
    Button btn_move_list_list1;
    Button btn_move_list_list2;
    Button btn_move_list_list3;
    Button btn_move_list_list4;
    Button btn_move_list_list5;
    Button btn_move_list_list6;
    Button btn_move_list_list7;

    ImageButton deleteBtn;
    LinearLayoutManager mLayoutManager;
    Adapter adapter;
    ArrayList<Item> itemDatas;

    Context context;

    JSONArray closetArray;
    int id;
    boolean isBasic;
    int basicId;
    int clothOwnerId;
    String clothImage;
    String clothId;
    int category;
    String color;
    String memo;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));

        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list1);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list2);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list3);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list4);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list5);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list6);
        btn_move_list_list1 = (Button) rootView.findViewById(R.id.btn_move_list_list7);

        addBtn = (ImageButton) rootView.findViewById(R.id.addBtn);

        initialLoad();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

                alertDialogBuilder
                        .setMessage("옷을 추가할 방법을 선택해주세요")
                        .setCancelable(false)
                        .setPositiveButton("직접 추가",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(getActivity().getApplication(), RegisterActivity.class);
                                        startActivity(intent);
                                    }
                                }
                        )
                        .setNegativeButton("리스트 추가",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        moveListRegister2();

                                    }

                                    public void moveListRegister2()
                                    {
                                        Intent intent = new Intent (getActivity() , ListRegisterActivity.class);
                                        startActivity(intent);
                                    }


                                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });


            recyclerView.setHasFixedSize(true);


            itemDatas = new ArrayList<Item>();
//            itemDatas.add(new Item(R.drawable.photo_md2, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.img_my, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.arrow, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.arrow, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.arrow, "아디다스 후드티", "박시한 스타일"));
//            itemDatas.add(new Item(R.drawable.gallery, "아디다스 후드티", "박시한 스타일"));




//        adapter.notifyDataSetChanged();
        return rootView;
    }

    private void initialLoad() {
//        String postUrl = "http://52.79.141.30:5000/closet/1/6";
//
//        Vector<NameValuePair> nameValue = new Vector<NameValuePair>();
//        nameValue.add(new BasicNameValuePair("url", postUrl));
////        nameValue.add(new BasicNameValuePair("user_id", userid));
//
//        HttpTask httpTask = new HttpTask("");
//        httpTask.execute(nameValue);

        String postUrl ="http://52.79.141.30:5000/closet/1/6";
        (new HttpPingAsyncTask()).execute(postUrl);
    }

    protected void startFragment(Fragment fragment, FragmentManager fm, Class<?> fragmentClass) {
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (fragment == null) {
            throw new IllegalStateException("cannot start fragment. " + fragmentClass.getName());
        }
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment).commit();
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

            Log.e("tag", jObject.toString());

            try {
                closetArray = jObject.getJSONArray("closet");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < closetArray.length(); i++) {
                try {
                    id = closetArray.getJSONObject(i).getInt("id");
                    isBasic = closetArray.getJSONObject(i).getBoolean("is_basic");
//                    basicId = closetArray.getJSONObject(i).getInt("basic_id");
                    clothOwnerId = closetArray.getJSONObject(i).getInt("cloth_owner_id");
                    clothImage = closetArray.getJSONObject(i).getString("cloth_image");
                    clothId = closetArray.getJSONObject(i).getString("cloth_id");
                    category = closetArray.getJSONObject(i).getInt("category");
                    color = closetArray.getJSONObject(i).getString("color");
                    memo = closetArray.getJSONObject(i).getString("memo");

                    Log.e("tag", closetArray.getJSONObject(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                itemDatas.add(new Item(clothImage, clothId, memo));


            }
            adapter = new Adapter(itemDatas);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }



    public class HttpTask extends AsyncTask<Vector<NameValuePair>, Void, String> {
        private final String TAG = "HttpTest";
        private String urlPath;

        private String str;

        public HttpTask(String str) {
            this.str = str;
        }

        @Override
        protected String doInBackground(Vector<NameValuePair>... nv) {

            try {
                urlPath = new String(nv[0].elementAt(0).getValue());
                Log.d(TAG, urlPath);

                HttpPost request = new HttpPost(urlPath);

                HttpEntity enty = new UrlEncodedFormEntity(nv[0], HTTP.UTF_8);
                request.setEntity(enty);

                HttpClient client = new DefaultHttpClient();
                HttpResponse res = client.execute(request);

                HttpEntity entityResponse = res.getEntity();
                InputStream im = entityResponse.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(im, HTTP.UTF_8));

                String total = "";
                String tmp = "";

                while ((tmp = reader.readLine()) != null) {
                    if (tmp != null) {
                        total += tmp;
                    }
                }

                im.close();
                return total;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            return "";
        }

        protected void onPostExecute(String value) {
            super.onPostExecute(value);
            Log.d(TAG, value);

            if (str == "") {
                JSONObject jObject = null;
                try {
                    jObject = new JSONObject(value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e("tag", jObject.toString());

                try {
                    closetArray = jObject.getJSONArray("closet");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                { "closet": [
//                    {
//                        id : 식별번호(기본키)
//                        is_basic : 기본템인가 아닌가 구분(문자열 "true" or "false" 중 하나)
//                        basic_id : 기본템일 경우 기본템 식별번호(기본키, 사용자가 직접 등록한 거면 null)
//                        cloth_owner_id: 사용자 식별번호(= 요청값의 사용자 식별번호와 동일)
//                        cloth_image: 옷 이미지 url
//                        cloth_id: 옷 이름 (기본템인경우 미리 디비에 저장되어있는 옷이름, 사용자가 직접추가
//                        한 경우 사용자가 직접 입력한 옷 이름)
//                        category: 옷 종류(숫자 1부터 6까지 ex) 상의 = 1, 하의 =2)
//                        color : 사용자가 옷 직접 등록시 입력했던 옷 색깔
//                        memo : 사용자가 옷 직접 등록시 입력했던 메모
//                    }
//                    ]
//                }
                for (int i = 0; i < closetArray.length(); i++) {
                    try {
                        id = closetArray.getJSONObject(i).getInt("id");
                        isBasic = closetArray.getJSONObject(i).getBoolean("is_basic");
                        basicId = closetArray.getJSONObject(i).getInt("basic_id");
                        clothOwnerId = closetArray.getJSONObject(i).getInt("cloth_owner_id");
                        clothImage = closetArray.getJSONObject(i).getString("cloth_image");
                        clothId = closetArray.getJSONObject(i).getString("cloth_id");
                        category = closetArray.getJSONObject(i).getInt("category");
                        color = closetArray.getJSONObject(i).getString("color");
                        memo = closetArray.getJSONObject(i).getString("memo");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    itemDatas.add(new Item(clothImage, clothId, memo));

                }

                adapter = new Adapter(itemDatas);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        }
    }
}