package com.androidapp.fusedbloxxer.moto4rent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class PageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private int mBottomTabCount;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
    }

    void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int i) {
        if (mFragmentList.size() > 0 && i >= 0 && i < mFragmentList.size()) {
            return mFragmentList.get(i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
