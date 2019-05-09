package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel.MotorcycleDetailsActivity;
import com.androidapp.fusedbloxxer.moto4rent.R;

public class MotorcycleViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageViewDisplay, mImageViewLookingStatus;
    private TextView mTextViewModel, mTextViewPrice, mTextViewLooking,
            mTextViewDeposit;

    public ImageView getmImageViewDisplay() {
        return mImageViewDisplay;
    }

    public TextView getmTextViewModel() {
        return mTextViewModel;
    }

    public TextView getmTextViewPrice() {
        return mTextViewPrice;
    }

    public TextView getmTextViewLooking() {
        return mTextViewLooking;
    }

    public TextView getmTextViewDeposit() {
        return mTextViewDeposit;
    }

    public MotorcycleViewHolder(@NonNull View itemView) {
        super(itemView);

        initView(itemView);
    }

    public ImageView getmImageViewLookingStatus() {
        return mImageViewLookingStatus;
    }

    private void initView(final View itemView) {
        mImageViewLookingStatus = itemView.findViewById(R.id.image_view_looking);
        mTextViewPrice = itemView.findViewById(R.id.text_view_starting_price);
        mImageViewDisplay = itemView.findViewById(R.id.image_view_display);
        mTextViewDeposit = itemView.findViewById(R.id.text_view_deposit);
        mTextViewLooking = itemView.findViewById(R.id.text_view_looking);
        mTextViewModel = itemView.findViewById(R.id.text_view_model);

        mImageViewDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDetails = new Intent(itemView.getRootView().getContext(), MotorcycleDetailsActivity.class);
                itemView
                        .getRootView()
                        .getContext()
                        .startActivity(showDetails);
            }
        });
    }
}
