package com.code_challenges.traveljournal.PlanningList;

public class TravelPlan {
    private String mTravelDate;
    private String mLocationName;
    private int mImageSource;

    public String getmTravelDate() {
        return mTravelDate;
    }

    public void setmTravelDate(String mTravelDate) {
        this.mTravelDate = mTravelDate;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public void setmLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public int getmImageSource() {
        return mImageSource;
    }

    public void setmImageSource(int mImageSource) {
        this.mImageSource = mImageSource;
    }

    TravelPlan(String mTravelDate, String mLocationName, int mImageSource) {
        this.mImageSource = mImageSource;
        this.mLocationName = mLocationName;
        this.mTravelDate = mTravelDate;
    }
}
