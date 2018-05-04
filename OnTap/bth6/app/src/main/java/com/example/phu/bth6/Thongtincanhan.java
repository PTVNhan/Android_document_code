package com.example.phu.bth6;

import android.widget.TextView;

/**
 * Created by Phu on 4/23/2018.
 */
public class Thongtincanhan {
    String hoten;
    String Email;
    String NNYT;
    String Nganh;


    public Thongtincanhan(String hoten,String NNYT, String email, String nganh) {
        this.hoten = hoten;
        Email = email;
        this.NNYT = NNYT;
        Nganh = nganh;
    }


    public String getNNYT() {
        return NNYT;
    }

    public void setNNYT(String NNYT) {
        this.NNYT = NNYT;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String nganh) {
        Nganh = nganh;
    }

}
