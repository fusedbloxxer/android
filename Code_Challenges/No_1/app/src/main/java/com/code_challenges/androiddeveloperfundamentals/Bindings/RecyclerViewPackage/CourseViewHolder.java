package com.code_challenges.androiddeveloperfundamentals.Bindings.RecyclerViewPackage;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class CourseViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageViewPhoto;
    private TextView mTextViewCourseNumber;
    private TextView mTextViewCourseDescription;

    public ImageView getmImageViewPhoto() {
        return mImageViewPhoto;
    }

    public TextView getmTextViewCourseNumber() {
        return mTextViewCourseNumber;
    }

    public TextView getmTextViewCourseDescription() {
        return mTextViewCourseDescription;
    }

    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageViewPhoto = itemView.findViewById(R.id.image_view_item_course);
        mTextViewCourseDescription = itemView.findViewById(R.id.text_view_item_description);
        mTextViewCourseNumber = itemView.findViewById(R.id.text_view_item_week_number);
    }
}
