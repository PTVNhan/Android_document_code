package com.example.asus.otck;


public class HinhAnh {
    private int imgID;
    private String imgName;
    private String imgSize;

    public HinhAnh(int imgID, String imgName, String imgSize) {
        this.imgID = imgID;
        this.imgName = imgName;
        this.imgSize = imgSize;
    }

    public HinhAnh(int imgID) {
        this.imgID = imgID;
    }


    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgSize() {
        return imgSize;
    }

    public void setImgSize(String imgSize) {
        this.imgSize = imgSize;
    }
}
