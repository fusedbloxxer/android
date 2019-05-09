package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel.MiniGallery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.List;

public class MiniGalleryAdapter extends RecyclerView.Adapter<MiniGalleryViewHolder> {
    private List<MiniGalleryItem> mGalleryList;

    public MiniGalleryAdapter(List<MiniGalleryItem> mGalleryList) {
        this.mGalleryList = mGalleryList;
    }

    @NonNull
    @Override
    public MiniGalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mini_gallery_item, viewGroup, false);
        return new MiniGalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiniGalleryViewHolder miniGalleryViewHolder, int i) {
        MiniGalleryItem miniGalleryItem = mGalleryList.get(i);

        miniGalleryViewHolder
                .getImageView()
                .setImageResource(miniGalleryItem
                        .getImageResource());
    }

    @Override
    public int getItemCount() {
        return mGalleryList.size();
    }
}
