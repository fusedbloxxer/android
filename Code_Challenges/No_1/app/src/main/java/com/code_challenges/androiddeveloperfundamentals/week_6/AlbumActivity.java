package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

public class AlbumActivity extends AppCompatActivity implements TheListener {
    public static final String GALLERY_IMAGE_RESOURCE_ID = "img_id";

    private Fragment mFragmentGalleryPicker;
    private Fragment mFragmentGalleryViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        initView();
    }

    private void initView() {
        mFragmentGalleryPicker = new GalleryFragment();
        // mFragmentGalleryViewer =
    }

    @Override
    public void show(int imageResourceID) {
        Bundle bundle = new Bundle();
        bundle.putInt(GALLERY_IMAGE_RESOURCE_ID, imageResourceID);

        mFragmentGalleryViewer.setArguments(bundle);
    }
}
