package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_6.BlankFragment;
import com.code_challenges.androiddeveloperfundamentals.week_6.ImageFragment;

public class BottomNaviationActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private BottomNavigationView mBottomNavigationView;
    private PageAdapter mPageAdapter;
    private ViewPager mViewPager;
    private MenuItem mPreviousMenuElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_naviation);

        initView();
    }

    private void initView() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mViewPager = findViewById(R.id.view_pager);
        mToolbar = findViewById(R.id.tool_bar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mPageAdapter = new PageAdapter(getSupportFragmentManager());
        mPageAdapter.addFragment(new ImageFragment());
        mPageAdapter.addFragment(new BlankFragment());
        mPageAdapter.addFragment(new ImageFragment());

        mViewPager.setAdapter(mPageAdapter);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.assistant_tab: {
                        mViewPager.setCurrentItem(0);
                        mPreviousMenuElement = menuItem;
                        return true;
                    }
                    case R.id.photos_tab: {
                        mViewPager.setCurrentItem(1);
                        mPreviousMenuElement = menuItem;
                        return true;
                    }
                    case R.id.albums_tab: {
                        mViewPager.setCurrentItem(2);
                        mPreviousMenuElement = menuItem;
                        return true;
                    }
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
                if (mPreviousMenuElement != null) {
                    mPreviousMenuElement.setChecked(false);
                    mPreviousMenuElement = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuElement.setChecked(true);
                } else {
                    mPreviousMenuElement = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuElement.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
