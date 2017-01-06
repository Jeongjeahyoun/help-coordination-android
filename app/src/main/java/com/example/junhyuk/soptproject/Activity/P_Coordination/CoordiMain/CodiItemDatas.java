package com.example.junhyuk.soptproject.Activity.P_Coordination.CoordiMain;

/**
 * Created by jeongjeahyeon on 2017. 1. 3..
 */

public class CodiItemDatas {

    public String getAsker() {
        return profile_nickname ;
    }

    public void setAsker(String asker) {
        this.profile_nickname  = profile_nickname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String profile_nickname ;
    int image;
    String content;

    public CodiItemDatas( String profile_nickname , int image, String content) {

        this.profile_nickname  = profile_nickname ;
        this.image = image;
        this.content = content;
    }
}
