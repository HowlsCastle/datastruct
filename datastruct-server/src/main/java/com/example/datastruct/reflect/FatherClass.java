package com.example.datastruct.reflect;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class FatherClass {
    private String mFatherName;
    private int mFatherAge;

    public void printFatherMsg() {}

    public String getmFatherName() {
        return mFatherName;
    }

    public void setmFatherName(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public int getmFatherAge() {
        return mFatherAge;
    }

    public void setmFatherAge(int mFatherAge) {
        this.mFatherAge = mFatherAge;
    }
}
