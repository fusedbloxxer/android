package com.code_challenges.androiddeveloperfundamentals.Bindings.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class CourseDetailsFragment extends Fragment {
    private ImageView mImageView;
    private TextView mTextViewTitle;
    private TextView mTextViewDescription;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_course_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        mTextViewTitle = view.findViewById(R.id.text_view_course_details_title);
        mTextViewDescription = view.findViewById(R.id.text_view_course_details_description);
        mImageView = view.findViewById(R.id.image_view_course_details_image);
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getString("title") != null) {
                mTextViewTitle.setText(bundle.getString("title"));
            }
            if (bundle.getString("description") != null) {
                mTextViewDescription.setText(bundle.getString("description"));
            }
            if (bundle.getString("image") != null) {
                mImageView.setImageResource(bundle.getInt("image"));
            }
        }
    }
}
