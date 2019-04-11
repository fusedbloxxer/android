package com.code_challenges.traveljournal.PlanningList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.traveljournal.R;

public class TravelPlanViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageViewLocation;
    private TextView mTextViewTravelDate;
    private TextView mTextViewTravelLocation;
    private RatingBar mRatingBarTravel;

    public ImageView getmImageViewLocation() {
        return mImageViewLocation;
    }

    public TextView getmTextViewTravelDate() {
        return mTextViewTravelDate;
    }

    public TextView getmTextViewTravelLocation() {
        return mTextViewTravelLocation;
    }

    public RatingBar getmRatingBarTravel() {
        return mRatingBarTravel;
    }

    public TravelPlanViewHolder(@NonNull View itemView) {
        super(itemView);

        initView();
        setViews();

    }

    private void setViews() {
        mImageViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), getmTextViewTravelLocation()
                        .getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mRatingBarTravel = itemView.findViewById(R.id.rating_bar_item);
        mImageViewLocation = itemView.findViewById(R.id.image_view_location);
        mTextViewTravelDate = itemView.findViewById(R.id.text_view_date);
        mTextViewTravelLocation = itemView.findViewById(R.id.text_view_location_name);
    }
}
