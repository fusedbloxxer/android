package com.code_challenges.androiddeveloperfundamentals.week_6.CodeChallenge7;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_6.Tabs.PageAdapter;

public class MyAmazingLifeActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AmazingPageAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_amazing_life);

        initView();
    }

    private void initView() {
        mToolBar = findViewById(R.id.tab_tool_bar);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolBar.setTitle(getResources().getString(R.string.app_name));
        }
        setSupportActionBar(mToolBar);

        mTabLayout.addTab(mTabLayout.newTab().setText("Movie"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Pet"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Food"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mPageAdapter = new AmazingPageAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mPageAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                /*if (tab.getPosition() == 0) {
                    mToolBar.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.red));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.darker_red));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.yellowish));
                    }
                } else if (tab.getPosition() == 1) {
                    mToolBar.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.colorSecondary));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.colorSecondaryDark));
                } else if (tab.getPosition() == 2) {
                    mToolBar.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.green));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MyAmazingLifeActivity.this, R.color.darker_green));
                }*/
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
