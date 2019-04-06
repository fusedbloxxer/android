package com.code_challenges.androiddeveloperfundamentals.week_4.RecycledViewStudents;

public class Student {
    public String getmLastName() {
        return mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    private String mLastName;
    private String mFirstName;

    Student(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }
}
