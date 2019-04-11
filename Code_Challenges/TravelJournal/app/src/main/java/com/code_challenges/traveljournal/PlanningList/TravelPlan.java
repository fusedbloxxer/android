package com.code_challenges.traveljournal.PlanningList;

public class TravelPlan {
    private String mTravelDateStart;
    private String mTravelDateEnd;
    private String mLocationName;
    private int mImageSource;
    private String mTripType;
    private float mRating;
    private int mPrice;

    public String getmTravelDateEnd() {
        return mTravelDateEnd;
    }

    public float getmRating() {
        return mRating;
    }

    public int getmPrice() {
        return mPrice;
    }

    public String getmTripType() {
        return mTripType;
    }

    public String getmTravelDateStart() {
        return mTravelDateStart;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public int getmImageSource() {
        return mImageSource;
    }

    private TravelPlan(Builder builder) {
        this.mImageSource = builder.mImageSource;
        this.mLocationName = builder.mLocationName;
        this.mPrice = builder.mPrice;
        this.mRating = builder.mRating;
        this.mTravelDateEnd = builder.mTravelDateEnd;
        this.mTravelDateStart = builder.mTravelDateStart;
        this.mTripType = builder.mTripType;
    }

    public static class Builder {
        private String mTravelDateStart;
        private String mTravelDateEnd;
        private String mLocationName;
        private int mImageSource;
        private String mTripType;
        private float mRating;
        private int mPrice;

        public Builder setmTravelDateStart(String mTravelDateStart) {
            this.mTravelDateStart = mTravelDateStart;
            return this;
        }

        public Builder setmTravelDateEnd(String mTravelDateEnd) {
            this.mTravelDateEnd = mTravelDateEnd;
            return this;
        }

        public Builder setmLocationName(String mLocationName) {
            this.mLocationName = mLocationName;
            return this;
        }

        public Builder setmImageSource(int mImageSource) {
            this.mImageSource = mImageSource;
            return this;
        }

        public Builder setmRating(float mRating) {
            this.mRating = mRating;
            return this;
        }


        public Builder setmPrice(int mPrice) {
            this.mPrice = mPrice;
            return this;
        }

        public Builder setmTripType(String mTripType) {
            this.mTripType = mTripType;
            return this;
        }

        public TravelPlan build() {
            return new TravelPlan(this);
        }
    }
}
