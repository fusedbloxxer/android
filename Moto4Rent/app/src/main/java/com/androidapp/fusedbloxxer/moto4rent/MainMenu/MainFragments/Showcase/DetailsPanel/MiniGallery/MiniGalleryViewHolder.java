package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel.MiniGallery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.androidapp.fusedbloxxer.moto4rent.R;

public class MiniGalleryViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;

    public ImageView getImageView() {
        return mImageView;
    }

    public MiniGalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.image_view);
    }
}
