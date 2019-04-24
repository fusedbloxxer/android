package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class GalleryItemViewHolder extends RecyclerView.ViewHolder {
    private int mImageResourceId;
    private ImagePreviewListener mImagePreviewListener;

    public ImageView getmImageViewGalleryItem() {
        return mImageViewGalleryItem;
    }

    public TextView getmTextViewGalleryItemNumber() {
        return mTextViewGalleryItemNumber;
    }

    private ImageView mImageViewGalleryItem;
    private TextView mTextViewGalleryItemNumber;

    public GalleryItemViewHolder(@NonNull final View itemView) {
        super(itemView);

        mImageViewGalleryItem = itemView.findViewById(R.id.image_view_gallery);
        mTextViewGalleryItemNumber = itemView.findViewById(R.id.text_view_gallery);

        mImagePreviewListener = (ImagePreviewListener) itemView.getContext();

        mImageViewGalleryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImagePreviewListener
                        .sendImageResource(mImageResourceId);
            }
        });
    }

    public void setImageResource(int imageResourceId) {
        mImageResourceId = imageResourceId;
        mImageViewGalleryItem.setImageResource(mImageResourceId);
    }
}
