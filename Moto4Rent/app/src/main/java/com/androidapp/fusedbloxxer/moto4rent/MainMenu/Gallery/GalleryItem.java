package com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery;

import android.graphics.Bitmap;

import java.util.Date;

public class GalleryItem {
    private Bitmap mBitmapImage;
    private int mImageResourceId;
    private String mTitle;
    private boolean mFavorite;
    private Date mDate;

    public boolean isFavorite() {
        return mFavorite;
    }

    public Date getDate() {
        return mDate;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Bitmap getBitmapImage() {
        return mBitmapImage;
    }

    private GalleryItem(GalleryItemBuilder galleryItemBuilder) {
        this.mImageResourceId = galleryItemBuilder.mImageResourceId;
        this.mTitle = galleryItemBuilder.mTitle;
        this.mDate = galleryItemBuilder.mDate;
        this.mFavorite = galleryItemBuilder.mFavorite;
    }

    public static class GalleryItemBuilder {
        private int mImageResourceId;
        private String mTitle;
        private boolean mFavorite;
        private Date mDate;
        private Bitmap mBitmapImage;

        GalleryItemBuilder(int imageResourceId, String title, Date mDate) {
            this.mImageResourceId = imageResourceId;
            this.mTitle = title;
            this.mDate = mDate;
        }

        GalleryItemBuilder(Bitmap mBitmapImage, String title, Date mDate) {
            this.mBitmapImage = mBitmapImage;
            this.mTitle = title;
            this.mDate = mDate;
        }

        public GalleryItemBuilder setFavorite(boolean favorite) {
            mFavorite = favorite;
            return this;
        }

        public GalleryItem build() {
            return new GalleryItem(this);
        }
    }
}
