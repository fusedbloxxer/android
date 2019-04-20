package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class GalleryItemViewHolder extends RecyclerView.ViewHolder {
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
    }
}
