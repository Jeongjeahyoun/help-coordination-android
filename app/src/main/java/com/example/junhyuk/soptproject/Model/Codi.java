package com.example.junhyuk.soptproject.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jeongjeahyeon on 2017. 1. 3..
 */

public class Codi {
        int id;
        @SerializedName("ask_id") String askid;
        String asker;
        String codi;
        String contents;
        String image1;
        String image2;
        String image3;
        String image4;
        String image5;
        String image6;
        int like;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAskid() {
            return askid;
        }

        public void setAskid(String askid) {
            this.askid = askid;
        }

        public String getAsker() {
            return asker;
        }

        public void setAsker(String asker) {
            this.asker = asker;
        }

        public String getCodi() {
            return codi;
        }

        public void setCodi(String codi) {
            this.codi = codi;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getImage1() {
            return image1;
        }

        public void setImage1(String image1) {
            this.image1 = image1;
        }

        public String getImage2() {
            return image2;
        }

        public void setImage2(String image2) {
            this.image2 = image2;
        }

        public String getImage3() {
            return image3;
        }

        public void setImage3(String image3) {
            this.image3 = image3;
        }

        public String getImage4() {
            return image4;
        }

        public void setImage4(String image4) {
            this.image4 = image4;
        }

        public String getImage5() {
            return image5;
        }

        public void setImage5(String image5) {
            this.image5 = image5;
        }

        public String getImage6() {
            return image6;
        }

        public void setImage6(String image6) {
            this.image6 = image6;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }






        @SerializedName("is_basic") boolean isBasic;
        @SerializedName("cloth_owner") String clothowner;
        @SerializedName("cloth_image") String clothimage;
        @SerializedName("cloth_id") String clothid;
        int category;
        String color;
        String momo;

        public boolean isBasic() {
            return isBasic;
        }

        public void setBasic(boolean basic) {
            isBasic = basic;
        }

        public String getClothowner() {
            return clothowner;
        }

        public void setClothowner(String clothowner) {
            this.clothowner = clothowner;
        }

        public String getClothimage() {
            return clothimage;
        }

        public void setClothimage(String clothimage) {
            this.clothimage = clothimage;
        }

        public String getClothid() {
            return clothid;
        }

        public void setClothid(String clothid) {
            this.clothid = clothid;
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

        public String getMomo() {
            return momo;
        }

        public void setMomo(String momo) {
            this.momo = momo;
        }



}


