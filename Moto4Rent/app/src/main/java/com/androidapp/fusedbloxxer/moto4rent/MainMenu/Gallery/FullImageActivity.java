package com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.io.ByteArrayInputStream;
import java.util.Date;

public class FullImageActivity extends AppCompatActivity {
    public static final String TEXT_VISIBILITY = "text_view_visibility";
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEXT_VISIBILITY, mTextViewTitle.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int visibility = savedInstanceState.getInt(TEXT_VISIBILITY);
        mTextViewTitle.setVisibility(visibility);
        mTextViewDate.setVisibility(visibility);
    }

    private void setResources() {
        Bundle extras = getIntent().getExtras();
        mTextViewTitle
                .setText(extras.getString(GalleryItemViewHolder.IMAGE_TITLE));

        // Get bitmap
        byte[] bytes = extras.getByteArray(GalleryItemViewHolder.IMAGE_BITMAP);
        if (bytes != null) {
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            mImageView
                    .setImageBitmap(bitmap);
        } else {
            // else get the image id
            mImageView
                    .setImageResource(extras.getInt(GalleryItemViewHolder.IMAGE_ID));
        }

        // Get the date
        mTextViewDate
                .setText(new Date(extras.getLong(GalleryItemViewHolder.DATE_TAKEN))
                        .toString());
        // Set back button
        showToolbar();
    }

    private void showToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
