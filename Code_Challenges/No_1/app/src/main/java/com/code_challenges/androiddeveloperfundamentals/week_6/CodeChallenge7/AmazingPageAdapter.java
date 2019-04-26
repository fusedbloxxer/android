package com.code_challenges.androiddeveloperfundamentals.week_6.CodeChallenge7;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.code_challenges.androiddeveloperfundamentals.R;

public class AmazingPageAdapter extends FragmentPagerAdapter {
    private int mTabCount;

    public AmazingPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        mTabCount = tabCount;
    }

    @Override
    public Fragment getItem(int item) {
        switch (item) {
            case 0: {
                ShowCaseFragment showCaseFragment = new ShowCaseFragment();
                showCaseFragment.setImage(R.drawable.movie_image);
                showCaseFragment.setTitle("The Empire Strikes Back");
                return showCaseFragment;
            }
            case 1: {
                ShowCaseFragment showCaseFragment = new ShowCaseFragment();
                showCaseFragment.setImage(R.drawable.pet_image);
                return showCaseFragment;
            }
            case 2: {
                ShowCaseFragment showCaseFragment = new ShowCaseFragment();
                showCaseFragment.setImage(R.drawable.food_image);
                showCaseFragment.setTitle("Shaorma");
                return showCaseFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
}
