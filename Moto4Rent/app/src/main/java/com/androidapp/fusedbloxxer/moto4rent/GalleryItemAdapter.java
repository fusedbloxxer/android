package com.androidapp.fusedbloxxer.moto4rent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;

public class GalleryItemAdapter extends RecyclerView.Adapter<GalleryItemViewHolder> {
    private List<GalleryItem> mGalleryList;

    GalleryItemAdapter(List<GalleryItem> galleryItems) {
        mGalleryList = galleryItems;
    }

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.gallery_image_item, viewGroup, false);
        return new GalleryItemViewHolder(itemView, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemViewHolder galleryItemViewHolder, int i) {
        GalleryItem galleryItem = mGalleryList.get(i);
        if (galleryItem != null) {
            Date date = galleryItem.getDate();
            if (date != null) {
                galleryItemViewHolder
                        .setDate(date);
            }
            Integer resourceId = galleryItem
                    .getImageResourceId();
            if (resourceId != null) {
                galleryItemViewHolder
                        .setImageId(resourceId);
            }
            String title = galleryItem.getTitle();
            if (title != null) {
                galleryItemViewHolder
                        .getTextViewGalleryTitle()
                        .setText(title);
            }
            Boolean isFavorite = galleryItem
                    .isFavorite();
            if (isFavorite != null) {
                if (isFavorite) {
                    galleryItemViewHolder
                            .getRatingBarFavorite()
                            .setRating(1);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mGalleryList.size();
    }
}
