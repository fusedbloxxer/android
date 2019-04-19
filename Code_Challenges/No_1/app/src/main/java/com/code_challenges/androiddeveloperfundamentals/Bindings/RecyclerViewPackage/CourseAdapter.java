package com.code_challenges.androiddeveloperfundamentals.Bindings.RecyclerViewPackage;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
    private List<Course> mCourseList;
    private View.OnClickListener mItemOnClickListener;

    public CourseAdapter(List<Course> courseList, View.OnClickListener onClickListener) {
        mCourseList = courseList;
        mItemOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item, viewGroup, false);

        // Good job !!
        itemView.setOnClickListener(mItemOnClickListener);

        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder courseViewHolder, int i) {
        Course course = mCourseList.get(i);

        if (course != null) {
            if (course.getmActivities() != null) {
                // TODO: Fragment work
            }
            if (course.getmCourseDescription() != null) {
                courseViewHolder.getmTextViewCourseDescription().setText(course.getmCourseDescription());
            }
            if (course.getmCourseNumber() != null) {
                courseViewHolder.getmTextViewCourseNumber().setText("Week number " + course.getmCourseNumber());
            }
            if (course.getmImageResourceID() != null) {
                courseViewHolder.getmImageViewPhoto().setImageResource(course.getmImageResourceID());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }
}
