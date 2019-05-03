package com.androidapp.fusedbloxxer.moto4rent;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.Date;

public class FullImageActivity extends AbstractPortraitActivity {
    private Toolbar mToolbar;
    private TextView mTextViewDate;
    private ImageView mImageView;
    private TextView mTextViewTitle;
    private ConstraintSet mConstraintSetDefault;
    private ConstraintLayout mConstraintLayout;
    private ConstraintSet mConstraintSetAlt;

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
        Bundle extras = getIntent().getExtras();
        mTextViewTitle
                .setText(extras.getString(GalleryItemViewHolder.IMAGE_TITLE));
        // Get the image id
        mImageView
                .setImageResource(extras.getInt(GalleryItemViewHolder.IMAGE_ID));
        // Get the date
        mTextViewDate
                .setText(new Date(extras.getLong(GalleryItemViewHolder.DATE_TAKEN))
                        .toString());
        // Set back button
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
        mTextViewTitle = findViewById(R.id.text_view_title);
        mToolbar = findViewById(R.id.toolbar_gallery);
        mImageView = findViewById(R.id.image_view_gallery_full);
        mTextViewDate = findViewById(R.id.text_view_date);
        mConstraintLayout = findViewById(R.id.constraint_layout);

        mConstraintSetAlt = new ConstraintSet();
        mConstraintSetDefault = new ConstraintSet();
        mConstraintSetDefault.clone(mConstraintLayout);
        mConstraintSetAlt.clone(this, R.layout.activity_full_image_alt);


    }

    private void showTextViews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(mConstraintLayout);
            mConstraintSetDefault.applyTo(mConstraintLayout);
        }
    }

    private void hideTextViews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(mConstraintLayout);
            mConstraintSetAlt.applyTo(mConstraintLayout);
        }
    }

    public void hideElementsOnClick(View view) {
        if (mTextViewDate.getVisibility() == View.VISIBLE) {
            hideTextViews();
        } else {
            showTextViews();
        }
    }
}
