package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase;

import java.util.HashMap;
import java.util.Map;

public class Motorcycle {
    public static final String KEY_IMAGE = "image";
    public static final String KEY_MODEL = "model";
    public static final String KEY_DRIVER = "driver";
    public static final String KEY_DEPOSIT = "deposit";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_START_PRICE = "start_price";
    public static final String KEY_START_DATE = "start_date";
    public static final String KEY_END_DATE = "end_date";
    public static final String KEY_LOOKING = "looking";
    public static final String KEY_RATING = "rating";

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

    public String getInterval() {
        String startDate = mStringMap.get(KEY_START_DATE);
        String endDate = mStringMap.get(KEY_END_DATE);

        if (startDate != null && endDate != null) {
            return startDate + " : "+ endDate;
        }
        return null;
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
            mStringMap.put(KEY_MODEL, name);
            mStringMap.put(KEY_CATEGORY, categ);
            mStringMap.put(KEY_DRIVER, driver);

            mIntegerMap = new HashMap<>();
            mIntegerMap.put(KEY_IMAGE, image);
            mIntegerMap.put(KEY_DEPOSIT, deposit);
            mIntegerMap.put(KEY_START_PRICE, sPrice);

            mParbriz = parbriz;
        }

        public MotorcycleBuilder setInterval(String start, String end) {
            mStringMap.put(KEY_START_DATE, start);
            mStringMap.put(KEY_END_DATE, end);
            return this;
        }

        public MotorcycleBuilder setBIGDescription(String description) {
            mStringMap.put(KEY_DESCRIPTION, description);
            return this;
        }

        public MotorcycleBuilder setCurrentLookingPeople(int currentLookingPeople) {
            mIntegerMap.put(KEY_LOOKING, currentLookingPeople);
            return this;
        }

        public MotorcycleBuilder setRating(float rating, int numberOfRatings) {
            this.mRating = rating;
            mIntegerMap.put(KEY_RATING, numberOfRatings);
            return this;
        }

        public Motorcycle build() {
            return new Motorcycle(this);
        }
    }
}
