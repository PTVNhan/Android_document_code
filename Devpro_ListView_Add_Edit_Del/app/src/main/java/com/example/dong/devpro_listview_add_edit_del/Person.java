package com.example.dong.devpro_listview_add_edit_del;

import java.io.Serializable;

/**
 * Created by Dong on 6/6/2016.
 */
public class Person implements Serializable {
    int code; // Xuât sô
    private int avatar;
    private String name;
    private String address;
    private String phone;

    public Person(int code, int avatar, String name, String address, String phone) {
        this.code = code;
        this.avatar = avatar;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
