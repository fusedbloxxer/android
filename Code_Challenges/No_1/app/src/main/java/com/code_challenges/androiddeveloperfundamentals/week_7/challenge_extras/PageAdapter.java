package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private int fragmentCount;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        fragmentCount = 0;
        mFragmentList = new ArrayList<>();
    }

    public void addFragment(Fragment mFragment) {
        mFragmentList.add(mFragment);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
