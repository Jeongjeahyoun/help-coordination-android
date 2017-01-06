package com.example.junhyuk.soptproject.Network;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jeongjeahyeon on 2017. 1. 2..
 */

public class MyClosetServiceBuilder extends Application {

    private static MyClosetServiceBuilder instance;


    private final String API_URL = "52.79.141.30:5000";

    /*public MyClosetService getService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        MyClosetService service = retrofit.create(MyClosetService.class);
        return service;
    }*/

    private com.example.junhyuk.soptproject.Network.MyClosetService MyClosetService;

    public static MyClosetServiceBuilder getInstance() {
        return instance;
    }

    public com.example.junhyuk.soptproject.Network.MyClosetService getMyClosetService() {return MyClosetService;}

    @Override
    public void onCreate() {
        super.onCreate();
        MyClosetServiceBuilder.instance = this;

        // TODO: 2016. 11. 21. 어플리케이션 초기 실행 시, retrofit을 사전에 build한다.
        buildService();
    }

    public void buildService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyClosetService = retrofit.create(com.example.junhyuk.soptproject.Network.MyClosetService.class);
    }
}
