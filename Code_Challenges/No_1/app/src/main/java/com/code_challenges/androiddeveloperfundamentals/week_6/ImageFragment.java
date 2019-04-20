package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class ImageFragment extends Fragment {
    private ImageView mImageViewItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageViewItem = view.findViewById(R.id.image_view_gallery_item);
    }

    public void setGalleryImage(int galleryImage) {
        mImageViewItem.setImageResource(galleryImage);
    }
}