package com.androidapp.fusedbloxxer.moto4rent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {
    private RecyclerView mRecyclerViewGallery;
    private List<GalleryItem> mGalleryList;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerViewGallery = view.findViewById(R.id.recycler_view_gallery);

        setData();
        setLayoutManager();
        setAdapter();
    }

    private void setAdapter() {
        mRecyclerViewGallery.setAdapter(new GalleryItemAdapter(mGalleryList));
    }

    private void setLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewGallery.setLayoutManager(staggeredGridLayoutManager);
    }

    private void setData() {
        // TODO: Preluare imagini din baza de date.
        mGalleryList = new ArrayList<>();
        mGalleryList.add(new GalleryItem
                .GalleryItemBuilder(R.drawable.moto_display_kawasaki_zr7, "Kawa")
                .setDate(new Date())
                .setFavorite(true)
                .build());
        mGalleryList.add(new GalleryItem
                .GalleryItemBuilder(R.drawable.moto_display_yamaha_supertenere, "Supertenere")
                .setDate(new Date())
                .setFavorite(false)
                .build());
        mGalleryList.add(new GalleryItem
                .GalleryItemBuilder(R.drawable.moto_display_suzuki_gs500e, "GS500E")
                .setDate(new Date())
                .setFavorite(true)
                .build());
    }
}
