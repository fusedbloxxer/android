package com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.fusedbloxxer.moto4rent.MainMenu.NavigationDrawerActivity;
import com.androidapp.fusedbloxxer.moto4rent.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements GalleryListener {
    public static final String CURRENT_FRAGMENT = "current_fragment";
    private GalleryPageAdapter mGalleryPageAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private boolean mTab;

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_gallery, container, false);
        initView(itemView);
        return itemView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAdapter();
    }

    private void setAdapter() {
        mGalleryPageAdapter = new GalleryPageAdapter(
                getChildFragmentManager(),
                4);
    }

    private void initView(View itemView) {
        mViewPager = itemView.findViewById(R.id.view_pager_gallery);
        mTabLayout = itemView.findViewById(R.id.tab_layout_gallery);

        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_photo_camera_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText("Gallery"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Favorite"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Recent"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager.setAdapter(mGalleryPageAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO: !!! Lansare Camera si preluare imagine in activitate separata cand se
                // apasa pe tabul cu Camera.

                mViewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    hideTabLayout();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    showTabLayout();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        // Select gallery as primary tab
        mViewPager.setCurrentItem(1);
    }

    @Override
    public void showTabLayout() {
        mTabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTabLayout() {
        mTabLayout.setVisibility(View.GONE);
    }
}
