package com.code_challenges.androiddeveloperfundamentals.week_6.CodeChallenge7;


import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowCaseFragment extends Fragment {
    private int mImageResource;
    private String mTitle;
    private int mColor;
    private TextView mTextViewName;
    private ImageView mImageView;
    private CardView mCardViewTitle;
    private CardView mCardViewPhoto;

    public ShowCaseFragment() {
        // Default constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_show_case, container, false);

        initView(itemView);

        return itemView;
    }

    private void initView(View container) {
        mImageView = container.findViewById(R.id.image_view_photo);
        mTextViewName = container.findViewById(R.id.text_view_name);
        mCardViewTitle = container.findViewById(R.id.card_view_title);
        mCardViewPhoto = container.findViewById(R.id.card_view_photo);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageView.setImageResource(mImageResource);
        if (mTitle == null || mTitle.isEmpty()) {
            mCardViewTitle.setVisibility(View.GONE);
        } else {
            mCardViewTitle.setVisibility(View.VISIBLE);
            mTextViewName.setText(mTitle);
        }
    }

    public void setImage(int imageResource) {
        this.mImageResource = imageResource;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
