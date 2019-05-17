package com.androidapp.fusedbloxxer.networkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class RobloxActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PageAdapterRoblox mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initView();
    }

    private void initView() {
        getSupportActionBar().setTitle("Roblox Viewer");
        mTabLayout = findViewById(R.id.tablayout);
        mViewPager = findViewById(R.id.view_pager_movie);

        mTabLayout.addTab(mTabLayout.newTab().setText("User Info"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Friends"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Games"));

        mPageAdapter = new PageAdapterRoblox(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mPageAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
}
