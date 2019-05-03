package com.androidapp.fusedbloxxer.moto4rent;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    private GalleryPageAdapter mGalleryPageAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

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

    private void initView(View itemView) {
        mViewPager = itemView.findViewById(R.id.view_pager_gallery);
        mTabLayout = itemView.findViewById(R.id.tab_layout_gallery);

        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_photo_camera_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText("Gallery"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Favorite"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Recent"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mGalleryPageAdapter = new GalleryPageAdapter(
                getActivity().getSupportFragmentManager(),
                mTabLayout.getTabCount());
        mViewPager.setAdapter(mGalleryPageAdapter);

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
