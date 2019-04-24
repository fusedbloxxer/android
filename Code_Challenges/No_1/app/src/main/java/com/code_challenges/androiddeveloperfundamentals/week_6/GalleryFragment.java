package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private List<GalleryItem> mGalleryItemList;
    private RecyclerView mRecyclerViewGallery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mRecyclerViewGallery = view.findViewById(R.id.recycler_view_gallery);
        addData();
        setLayoutManager(view);
        setAdapter();
    }

    private void setAdapter() {
        mRecyclerViewGallery.setAdapter(new GalleryAdapter(mGalleryItemList));
    }

    private void addData() {
        if (mGalleryItemList == null) {
            mGalleryItemList = new ArrayList<>();
        }
        mGalleryItemList.add(new GalleryItem(R.drawable.android_1));
        mGalleryItemList.add(new GalleryItem(R.drawable.android_2));
        mGalleryItemList.add(new GalleryItem(R.drawable.android_3));
        mGalleryItemList.add(new GalleryItem(R.drawable.android_4));
        mGalleryItemList.add(new GalleryItem(R.drawable.android_5));
    }

    private void setLayoutManager(View view) {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewGallery.setLayoutManager(layoutManager);
    }

    public RecyclerView getmRecyclerViewGallery() {
        return mRecyclerViewGallery;
    }
}
