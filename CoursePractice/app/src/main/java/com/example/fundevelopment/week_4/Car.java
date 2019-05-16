package com.example.fundevelopment.week_4;

public class Car {
    private String mName;
    private String mColor;
    private int mHp;

    public Car(String mName, String mColor, int mHp) {
        this.mName = mName;
        this.mColor = mColor;
        this.mHp = mHp;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public int getmHp() {
        return mHp;
    }

    public void setmHp(int mHp) {
        this.mHp = mHp;
    }
}
