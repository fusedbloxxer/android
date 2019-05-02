package com.androidapp.fusedbloxxer.moto4rent;

import java.util.HashMap;
import java.util.Map;

public class Motorcycle {
    private Map<String, Integer> mIntegerMap;
    private Map<String, String> mStringMap;
    private boolean mParbriz;
    private float mRating;

    public String getStringValue(String key) {
        return mStringMap.get(key);
    }

    public Integer getIntValue(String key) {
        return mIntegerMap.get(key);
    }

    public boolean isParbriz() {
        return mParbriz;
    }

    public float getRating() {
        return mRating;
    }

    Motorcycle(MotorcycleBuilder motorcycleBuilder) {
        mIntegerMap = motorcycleBuilder.mIntegerMap;
        mStringMap = motorcycleBuilder.mStringMap;
        mParbriz = motorcycleBuilder.mParbriz;
        mRating = motorcycleBuilder.mRating;
    }

    public static class MotorcycleBuilder {
        private Map<String, Integer> mIntegerMap;
        private Map<String, String> mStringMap;
        private boolean mParbriz;
        private float mRating;

        public MotorcycleBuilder(String name, String categ, String driver,
                                 int image, int deposit, int sPrice, boolean parbriz) {
            mStringMap = new HashMap<>();
            mStringMap.put("model", name);
            mStringMap.put("category", categ);
            mStringMap.put("driver", driver);

            mIntegerMap = new HashMap<>();
            mIntegerMap.put("image", image);
            mIntegerMap.put("deposit", deposit);
            mIntegerMap.put("start_price", sPrice);

            mParbriz = parbriz;
        }

        public MotorcycleBuilder setInterval(String start, String end) {
            mStringMap.put("start_date", start);
            mStringMap.put("end_date", end);
            return this;
        }

        public MotorcycleBuilder setBIGDescription(String description) {
            mStringMap.put("description", description);
            return this;
        }

        public MotorcycleBuilder setCurrentLookingPeople(int currentLookingPeople) {
            mIntegerMap.put("looking", currentLookingPeople);
            return this;
        }

        public MotorcycleBuilder setRating(float rating, int numberOfRatings) {
            this.mRating = rating;
            mIntegerMap.put("rating", numberOfRatings);
            return this;
        }

        public Motorcycle build() {
            return new Motorcycle(this);
        }
    }
}
