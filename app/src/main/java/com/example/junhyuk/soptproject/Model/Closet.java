package com.example.junhyuk.soptproject.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jeongjeahyeon on 2017. 1. 2..
 */

public class Closet {
    int id;
    @SerializedName("is_basic") boolean isBasic;
    @SerializedName("cloth_owner") String clothOwner;
    @SerializedName("cloth_image") String clothImage;
    @SerializedName("cloth_id") String clothId;
    int category;
    String color;
    String memo;

    public boolean isBasic() {
        return isBasic;
    }

    public void setBasic(boolean basic) {
        isBasic = basic;
    }

    public String getClothOwner() {
        return clothOwner;
    }

    public void setClothOwner(String clothOwner) {
        this.clothOwner = clothOwner;
    }

    public String getClothImage() {
        return clothImage;
    }

    public void setClothImage(String clothImage) {
        this.clothImage = clothImage;
    }

    public String getClothId() {
        return clothId;
    }

    public void setClothId(String clothId) {
        this.clothId = clothId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
