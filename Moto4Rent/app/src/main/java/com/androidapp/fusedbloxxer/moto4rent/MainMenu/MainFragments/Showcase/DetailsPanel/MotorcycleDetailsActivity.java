package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;

import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel.MiniGallery.MiniGalleryAdapter;
import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase.DetailsPanel.MiniGallery.MiniGalleryItem;
import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleDetailsActivity extends AppCompatActivity {
    private List<MiniGalleryItem> mGalleryList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycle_details);

        initView();
        setData();
        setLayoutManager();
        setAdapter();
    }

    private void setAdapter() {
        mRecyclerView.setAdapter(new MiniGalleryAdapter(mGalleryList));
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void setData() {
        // TODO: Receive data from database
        mGalleryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mGalleryList.add(new MiniGalleryItem(R.drawable.moto_display_suzuki_gs500e));
            mGalleryList.add(new MiniGalleryItem(R.drawable.moto_display_kawasaki_zr7));
            mGalleryList.add(new MiniGalleryItem(R.drawable.moto_display_yamaha_supertenere));
            mGalleryList.add(new MiniGalleryItem(R.drawable.moto_display_yamaha_yzf_r6));
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view_mini_gallery);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                finish();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
