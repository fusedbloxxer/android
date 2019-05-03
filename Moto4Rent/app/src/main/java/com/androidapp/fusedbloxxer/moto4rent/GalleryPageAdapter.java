package com.androidapp.fusedbloxxer.moto4rent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Comparator;

class GalleryPageAdapter extends FragmentPagerAdapter {
    public static final String OPERATION = "operation"; // 1 - sort, 2 - filter
    private int mTabCount;

    public GalleryPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new CameraFragment();
        } else if (i == 1) {
            return new ImageFragment();
        } else if (i == 2) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle extras = new Bundle();
            extras.putInt(OPERATION, 2);
            imageFragment.setArguments(extras);
            return imageFragment;
        } else if (i == 3) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle extras = new Bundle();
            extras.putInt(OPERATION, 1);
            imageFragment.setArguments(extras);
            return imageFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
