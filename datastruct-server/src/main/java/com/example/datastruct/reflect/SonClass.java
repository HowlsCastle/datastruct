package com.example.datastruct.reflect;

public class SonClass extends FatherClass {
    private String mSonName;
    private int mSonAge;
    private String mSonBirthday;

    public void printSonMsg() {
        System.out.println("son name: "+mSonName + " age: "+mSonAge);
    }

    public String getmSonName() {
        return mSonName;
    }

    public void setmSonName(String mSonName) {
        this.mSonName = mSonName;
    }

    public int getmSonAge() {
        return mSonAge;
    }

    public void setmSonAge(int mSonAge) {
        this.mSonAge = mSonAge;
    }

    public String getmSonBirthday() {
        return mSonBirthday;
    }

    public void setmSonBirthday(String mSonBirthday) {
        this.mSonBirthday = mSonBirthday;
    }
}
