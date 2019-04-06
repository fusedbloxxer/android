package com.code_challenges.androiddeveloperfundamentals.week_4.RecycledViewStudents;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;

    public LinearLayout getmLinearLayoutBackground() {
        return mLinearLayoutBackground;
    }

    private LinearLayout mLinearLayoutBackground;

    public TextView getmTextViewFirstName() {
        return mTextViewFirstName;
    }

    public TextView getmTextViewLastName() {
        return mTextViewLastName;
    }

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        mLinearLayoutBackground = itemView.findViewById(R.id.linear_layout_background);
        mTextViewFirstName = itemView.findViewById(R.id.text_view_student_name_first);
        mTextViewLastName = itemView.findViewById(R.id.text_view_student_name_last);
    }
}
