package com.example.junhyuk.soptproject.Network;

import com.example.junhyuk.soptproject.Model.Closet;
import com.example.junhyuk.soptproject.Model.Codi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jeongjeahyeon on 2017. 1. 2..
 */

public interface MyClosetService {

    @GET("closet/{nickname}/{category}")
    Call<ArrayList<Closet>> getCloset(@Path("nickname") String nickname, @Path("category") int category);

    @GET("codi/posts/{nickname}")
    Call<ArrayList<Codi>> getCodi(@Path("nickname") String nickname);

    @GET("codi/{ask_id}")
    Call<ArrayList<Codi>>getCodi(@Path("ask_id") int ask_id);



    //코디하기에 게시판 등록




}
