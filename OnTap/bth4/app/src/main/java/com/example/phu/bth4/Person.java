package com.example.phu.bth4;

/**
 * Created by Phu on 4/26/2018.
 */
public class Person {

    String name;
    String sdt;
    public Person(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}