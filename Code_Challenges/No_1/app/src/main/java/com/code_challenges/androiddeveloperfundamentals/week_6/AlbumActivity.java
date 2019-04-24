package com.code_challenges.androiddeveloperfundamentals.week_6;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

public class AlbumActivity extends AppCompatActivity implements ImagePreviewListener {
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
        replaceFragment(R.id.frame_layout_fragment_dynamic, mFragmentGalleryPicker);
    }


    @Override
    public void sendImageResource(int imageResourceID) {
        sendMethod(imageResourceID);
    }

    private void sendMethod(int imageResourceID) {
        ImageFragment imageFragment = new ImageFragment();
        imageFragment.setGalleryImage(imageResourceID);
        replaceFragment(R.id.gallery_container, imageFragment);
    }

    private void replaceFragment(int containerId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.commit();
    }
}
