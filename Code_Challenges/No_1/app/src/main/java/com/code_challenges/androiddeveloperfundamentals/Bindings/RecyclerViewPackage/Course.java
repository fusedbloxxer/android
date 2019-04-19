package com.code_challenges.androiddeveloperfundamentals.Bindings.RecyclerViewPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {
    private Integer mImageResourceID;
    private Integer mCourseNumber;
    private String mCourseDescription;
    private List<Class> mActivities;

    public Integer getmImageResourceID() {
        return mImageResourceID;
    }

    public Integer getmCourseNumber() {
        return mCourseNumber;
    }

    public String getmCourseDescription() {
        return mCourseDescription;
    }

    public List<Class> getmActivities() {
        return mActivities;
    }

    private Course(Builder builder) {
        mActivities = builder.mActivities;
        mCourseDescription = builder.mCourseDescription;
        mCourseNumber = builder.mCourseNumber;
        mImageResourceID = builder.mImageResourceID;
    }

    public static class Builder {
        private Integer mImageResourceID;
        private Integer mCourseNumber;
        private String mCourseDescription;
        private List<Class> mActivities;

        public Builder(Integer imageResourceID, Integer courseNumber) {
            mImageResourceID = imageResourceID;
            mCourseNumber = courseNumber;
        }

        public Builder setActivities(Class... activitiesIDs) {
            if (mActivities == null) {
                mActivities = new ArrayList<>();
            }
            mActivities.addAll(Arrays.asList(activitiesIDs));
            return this;
        }

        public Builder setCourseDescription(String courseDescription) {
            mCourseDescription = courseDescription;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
