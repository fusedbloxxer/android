package com.androidapp.fusedbloxxer.networkingapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class PageAdapterRoblox extends FragmentPagerAdapter {
    private int mTabCount;

    public PageAdapterRoblox(FragmentManager fm, int tabCount) {
        super(fm);
        mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RobloxUserFragment();
        } else if (position == 1) {
            return new RobloxFriendsFragment();
        } else if (position == 2) {
            return new RobloxGamesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
