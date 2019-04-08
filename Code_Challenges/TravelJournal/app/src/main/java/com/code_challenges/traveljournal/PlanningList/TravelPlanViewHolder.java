package com.code_challenges.traveljournal.PlanningList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.traveljournal.R;

public class TravelPlanViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageViewLocation;

    public ImageView getmImageViewLocation() {
        return mImageViewLocation;
    }

    public TextView getmTextViewTravelDate() {
        return mTextViewTravelDate;
    }

    public TextView getmTextViewTravelLocation() {
        return mTextViewTravelLocation;
    }

    private TextView mTextViewTravelDate;
    private TextView mTextViewTravelLocation;


    public TravelPlanViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageViewLocation = itemView.findViewById(R.id.image_view_location);
        mTextViewTravelDate = itemView.findViewById(R.id.text_view_date);
        mTextViewTravelLocation = itemView.findViewById(R.id.text_view_location_name);


    }
}
