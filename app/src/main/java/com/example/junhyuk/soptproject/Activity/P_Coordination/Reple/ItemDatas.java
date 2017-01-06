package com.example.junhyuk.soptproject.Activity.P_Coordination.Reple;

/**
 * Created by jeongjeahyeon on 2017. 1. 2..
 */

public class ItemDatas {

    String rippleProfileName;
    int rippleImage1,rippleImage2,rippleImage3,rippleImage4,rippleImage5,rippleImage6;
    String txt_ripple;
    String rippleLikeNum;

    public ItemDatas(String rippleProfileName,  int rippleImage1, int rippleImage2, int rippleImage3, int rippleImage4, int rippleImage5, int rippleImage6, String txt_ripple, String rippleLikeNum) {
        this.rippleProfileName = rippleProfileName;
        this.rippleImage1 = rippleImage1;
        this.rippleImage2 = rippleImage2;
        this.rippleImage3 = rippleImage3;
        this.rippleImage4 = rippleImage4;
        this.rippleImage5 = rippleImage5;
        this.rippleImage6 = rippleImage6;
        this.rippleLikeNum = rippleLikeNum;
        this.txt_ripple = txt_ripple;
    }
}