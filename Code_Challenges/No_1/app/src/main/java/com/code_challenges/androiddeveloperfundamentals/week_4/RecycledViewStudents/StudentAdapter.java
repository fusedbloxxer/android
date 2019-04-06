package com.code_challenges.androiddeveloperfundamentals.week_4.RecycledViewStudents;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private List<Student> mStudentList;

    StudentAdapter(List<Student> studentList) {
        mStudentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_view, viewGroup, false);
        return new StudentViewHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {

        LinearLayout linearLayout = studentViewHolder.getmLinearLayoutBackground();
        Student currentStudent = mStudentList.get(i);

        if (currentStudent != null) {
            if (currentStudent.getmFirstName() != null) {
                studentViewHolder
                        .getmTextViewFirstName()
                        .setText(currentStudent.getmFirstName());
            }
            if (currentStudent.getmLastName() != null) {
                studentViewHolder
                        .getmTextViewLastName()
                        .setText(currentStudent.getmLastName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }
}
