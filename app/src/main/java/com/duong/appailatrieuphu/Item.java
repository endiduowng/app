package com.duong.appailatrieuphu;

/**
 * Created by Nguyen Duong on 30/08/2016.
 */
public class Item {
    private int idImage;
    private String tvContent;

    public Item(int idImage, String tvContent) {
        this.idImage = idImage;
        this.tvContent = tvContent;
    }

    public String getTvContent() {
        return tvContent;
    }

    public int getIdImage() {
        return idImage;
    }
}
