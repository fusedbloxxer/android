package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;

public class Sport {
    private int mImageResourceID;
    private String mSportName;
    private int mStartHour;
    private int mEndHour;
    private String mLocation;

    public Sport(int mImageResourceID, String mSportName, int mStartHour, int mEndHour, String mLocation) {
        this.mImageResourceID = mImageResourceID;
        this.mSportName = mSportName;
        this.mStartHour = mStartHour;
        this.mEndHour = mEndHour;
        this.mLocation = mLocation;
    }

    public int getStartHour() {
        return mStartHour;
    }

    public int getEndHour() {
        return mEndHour;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public String getSportName() {
        return mSportName;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getPeriod() {
        return mStartHour + " - " + mEndHour;
    }
}
