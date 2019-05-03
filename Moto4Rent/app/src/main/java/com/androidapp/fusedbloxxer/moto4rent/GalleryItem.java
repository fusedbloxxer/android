package com.androidapp.fusedbloxxer.moto4rent;

import java.util.Date;

public class GalleryItem {
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

        GalleryItemBuilder(int imageResourceId, String title) {
            this.mImageResourceId = imageResourceId;
            this.mTitle = title;
        }

        public GalleryItemBuilder setFavorite(boolean favorite) {
            mFavorite = favorite;
            return this;
        }

        public GalleryItemBuilder setDate(Date date) {
            this.mDate = date;
            return this;
        }

        public GalleryItem build() {
            return new GalleryItem(this);
        }
    }
}
