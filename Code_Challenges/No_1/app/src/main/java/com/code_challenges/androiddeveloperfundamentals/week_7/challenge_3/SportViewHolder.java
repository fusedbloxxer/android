package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class SportViewHolder extends RecyclerView.ViewHolder {
    private int mImageBackgroundID;
    private int mImageUserID;
    private int mImageCountryID;
    private int mImageResourceID;
    private int mExtraActivityID;
    private String mStringExtraActivityID;
    private TheListener myListener;
    private ImageView mImageViewSport;
    private TextView mTextViewSportName, mTextViewSportPeriod, mTextViewSportLocation;

    public SportViewHolder(@NonNull View itemView) {
        super(itemView);

        initView(itemView);
    }

    private void initView(final View itemView) {
        mImageViewSport = itemView.findViewById(R.id.image_view_sport);
        mTextViewSportLocation = itemView.findViewById(R.id.text_view_sport_location);
        mTextViewSportName = itemView.findViewById(R.id.text_view_sport_name);
        mTextViewSportPeriod = itemView.findViewById(R.id.text_view_sport_period);

        myListener = (TheListener) itemView.getContext();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListener.sendData(mImageResourceID,
                        mTextViewSportName.getText().toString(),
                        mTextViewSportPeriod.getText().toString(),
                        mTextViewSportLocation.getText().toString());
            }
        });
    }

    public ImageView getmImageViewSport() {
        return mImageViewSport;
    }

    public TextView getmTextViewSportName() {
        return mTextViewSportName;
    }

    public TextView getmTextViewSportPeriod() {
        return mTextViewSportPeriod;
    }

    public TextView getmTextViewSportLocation() {
        return mTextViewSportLocation;
    }

    public int getmImageBackgroundID() {
        return mImageBackgroundID;
    }

    public int getmImageUserID() {
        return mImageUserID;
    }

    public int getmImageCountryID() {
        return mImageCountryID;
    }

    public int getmImageResourcID() {
        return mImageResourceID;
    }

    public int getmExtraActivityID() {
        return mExtraActivityID;
    }

    public String getmStringExtraActivityID() {
        return mStringExtraActivityID;
    }

    public void setmImageBackgroundID(int mImageBackgroundID) {
        this.mImageBackgroundID = mImageBackgroundID;
    }

    public void setmImageUserID(int mImageUserID) {
        this.mImageUserID = mImageUserID;
    }

    public void setmImageCountryID(int mImageCountryID) {
        this.mImageCountryID = mImageCountryID;
    }

    public void setmImageResourceID(int mImageResourceID) {
        this.mImageResourceID = mImageResourceID;
    }

    public void setmExtraActivityID(int mExtraActivityID) {
        this.mExtraActivityID = mExtraActivityID;
    }

    public void setmStringExtraActivityID(String mStringExtraActivityID) {
        this.mStringExtraActivityID = mStringExtraActivityID;
    }
}
