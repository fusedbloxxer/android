package com.androidapp.fusedbloxxer.moto4rent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class FullImageActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTextViewDate;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        initView();
        setResources();
    }

    private void showToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setResources() {
        // Get the image id
        Bundle extras = getIntent().getExtras();
        mImageView
                .setImageResource(extras.getInt(GalleryItemViewHolder.IMAGE_ID));
        // Get the date
        mTextViewDate
                .setText(extras.getString(GalleryItemViewHolder.DATE_TAKEN));
        // Set back button
        if (mTextViewDate)

        showToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar_gallery);
        mImageView = findViewById(R.id.image_view_gallery_full);
        mTextViewDate = findViewById(R.id.text_view_date);
    }

    public void hideElementsOnClick(View view) {
        if (mTextViewDate.getText() != null
                && !mTextViewDate.getText().toString().isEmpty()) {

            if (mTextViewDate.getVisibility() == View.VISIBLE) {
                mTextViewDate
                        .setVisibility(View.GONE);
            } else {
                mTextViewDate
                        .setVisibility(View.VISIBLE);
            }
        }
    }
}
