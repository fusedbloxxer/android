package com.androidapp.fusedbloxxer.moto4rent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Date;

public class GalleryItemViewHolder extends RecyclerView.ViewHolder {
    public static final String IMAGE_ID = "image_id";
    public static final String DATE_TAKEN = "image_date";
    public static final String RATING = "rating";
    private ImageView mImageViewGallery;
    private TextView mTextViewGalleryTitle;
    private RatingBar mRatingBarFavorite;
    private Context mContext;
    private Date mDate;
    private int mImageId;

    public ImageView getImageViewGallery() {
        return mImageViewGallery;
    }

    public TextView getTextViewGalleryTitle() {
        return mTextViewGalleryTitle;
    }

    public RatingBar getRatingBarFavorite() {
        return mRatingBarFavorite;
    }

    public GalleryItemViewHolder(@NonNull View itemView, Context mContext) {
        super(itemView);
        this.mContext = mContext;
        initView(itemView);
    }

    private void initView(View itemView) {
        mImageViewGallery = itemView.findViewById(R.id.image_view_gallery);
        mTextViewGalleryTitle = itemView.findViewById(R.id.text_view_gallery_title);
        mRatingBarFavorite = itemView.findViewById(R.id.ratingbar_favorite);

        // View full image
        mImageViewGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openImage = new Intent(mContext, FullImageActivity.class);
                openImage.putExtra(IMAGE_ID, mImageId); // send image id
                openImage.putExtra(DATE_TAKEN, mDate); // send date
                openImage.putExtra(RATING, mRatingBarFavorite
                        .getRating());
                mContext.startActivity(openImage);
            }
        });

        //TODO: Listener pe fragmente
        // mRatingBarFavorite.setEnabled(false);
        mRatingBarFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRatingBarFavorite.getRating() == 1) {
                    mRatingBarFavorite.setRating(0);
                } else {
                    mRatingBarFavorite.setRating(1);
                }
            }
        });
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
        if (mImageViewGallery != null) {
            mImageViewGallery.setImageResource(mImageId);
        }
    }

    public void setDate(Date date) {
        mDate = date;
    }
}