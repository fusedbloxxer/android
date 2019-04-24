package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryItemViewHolder> {
    private List<GalleryItem> mGalleryItemList;

    GalleryAdapter(List<GalleryItem> galleryItems) {
        mGalleryItemList = galleryItems;
    }

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gallery_item_layout, viewGroup, false);

        return new GalleryItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemViewHolder galleryItemViewHolder, int i) {
        GalleryItem galleryItem = mGalleryItemList.get(i);

        if (galleryItem != null) {
            if (galleryItem.getmImageResourceID() != null) {
                galleryItemViewHolder
                        .setImageResource(galleryItem.getmImageResourceID());
                galleryItemViewHolder
                        .getmTextViewGalleryItemNumber()
                        .setText(String.valueOf(i));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mGalleryItemList.size();
    }
}
