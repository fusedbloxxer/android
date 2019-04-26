package com.code_challenges.androiddeveloperfundamentals.week_6.Tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.code_challenges.androiddeveloperfundamentals.week_6.BlankFragment;
import com.code_challenges.androiddeveloperfundamentals.week_6.GalleryFragment;
import com.code_challenges.androiddeveloperfundamentals.week_6.ImageFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int mTabCount;

    public PageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int item) {
        switch (item) {
            case 0:
                return new ImageFragment();
            case 1:
                return new BlankFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
