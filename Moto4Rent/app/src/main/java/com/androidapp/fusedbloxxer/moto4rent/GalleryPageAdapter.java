package com.androidapp.fusedbloxxer.moto4rent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class GalleryPageAdapter extends FragmentPagerAdapter {
    private int mTabCount;

    public GalleryPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new ImageFragment();
        } else if (i == 1) {
            return new FavoriteImageFragment();
        } else if (i == 2) {
            return new RecentImageFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
