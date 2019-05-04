package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.MenuItem;
import android.view.View;

import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Rent.RentFragment;
import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Trip.TripFragment;
import com.androidapp.fusedbloxxer.moto4rent.R;
import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.ShowCaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private BottomNavigationView mBottomNavigationView;
    private CoordinatorLayout mCoordinatorLayout;
    private PageAdapter mPageAdapter;
    private ViewPager mViewPager;
    private MenuItem mPreviousMenuItem;
    private int mBottomTabCount;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_home, container, false);
        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        setViewPagerAdapter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createAdapter();
    }

    private void createAdapter() {
        mPageAdapter = new PageAdapter(getChildFragmentManager());

        mPageAdapter.addFragment(new TripFragment());
        mPageAdapter.addFragment(new ShowCaseFragment());
        mPageAdapter.addFragment(new RentFragment());
    }

    private void initView(View itemView) {
        mCoordinatorLayout = itemView.findViewById(R.id.coordinator_layout);
        mBottomNavigationView = itemView.findViewById(R.id.bottom_navigation_view);
        mViewPager = itemView.findViewById(R.id.view_pager);
        mBottomTabCount = 3;
    }

    private void setViewPagerAdapter() {
        mViewPager.setAdapter(mPageAdapter);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.nav_bot_trip) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(0);
                    return true;
                } else if (id == R.id.nav_bot_showcase) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(1);
                    return true;
                } else if (id == R.id.nav_bot_rent) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mPreviousMenuItem != null) {
                    mPreviousMenuItem.setChecked(false);
                    mPreviousMenuItem = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuItem.setChecked(true);
                } else {
                    mPreviousMenuItem = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuItem.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mBottomNavigationView.setSelectedItemId(R.id.nav_bot_showcase);
    }

}
