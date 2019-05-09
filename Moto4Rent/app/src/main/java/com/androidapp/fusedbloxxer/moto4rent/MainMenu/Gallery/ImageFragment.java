package com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;


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
        view.setTag(R.string.image_fragment_tag);
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
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewGallery.setLayoutManager(staggeredGridLayoutManager);
    }

    private void setData() {
        // TODO: Preluare imagini din baza de date.
        mGalleryList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            mGalleryList.add(new GalleryItem
                    .GalleryItemBuilder(R.drawable.moto_display_kawasaki_zr7, "Kawa", new Date())
                    .setFavorite(false)
                    .build());
            mGalleryList.add(new GalleryItem
                    .GalleryItemBuilder(R.drawable.moto_display_yamaha_supertenere, "Supertenere", new Date())
                    .setFavorite(false)
                    .build());
            mGalleryList.add(new GalleryItem
                    .GalleryItemBuilder(R.drawable.moto_display_suzuki_gs500e, "GS500E", new Date())
                    .setFavorite(true)
                    .build());
        }


        Bundle extras = getArguments();
        if (extras != null) {
            int operation = extras.getInt(GalleryPageAdapter.OPERATION);
            switch (operation) {
                case 1: {
                    sort(new Comparator<GalleryItem>() {
                        @Override
                        public int compare(GalleryItem o1, GalleryItem o2) {
                            return o1
                                    .getDate().compareTo(o2.getDate());
                        }
                    });
                }
                break;
                case 2: {
                    filterByFavorite();
                }
            }
        }
    }

    public void addPicToGallery(Bitmap mBitmap, String title) {
        mGalleryList
                .add(new GalleryItem
                        .GalleryItemBuilder(mBitmap, title, new Date())
                .build());
    }

    public void sort(Comparator<? super GalleryItem> comparator) {
        Collections.sort(mGalleryList, comparator);
    }

    public void filterByFavorite() {
        ListIterator<GalleryItem> listIterator = mGalleryList.listIterator();
        while (listIterator.hasNext()) {
            if (!listIterator
                    .next()
                    .isFavorite()) {
                listIterator.remove();
            }
        }
    }
}
