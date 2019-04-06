package com.code_challenges.androiddeveloperfundamentals.week_4.RecycledViewStudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Student> mStudentList;
    private RecyclerView mRecyclerViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycled_view);

        initView();
        setLayoutManager();
        getDataSource();
        setAdapter();
    }

    private void getDataSource() {
        mStudentList = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            mStudentList.add(new Student("FirstName " + i + "", "LastName " + i + ""));
        }
    }

    private void setAdapter() {
        mRecyclerViewStudents.setAdapter(new StudentAdapter(mStudentList));
    }

    private void initView() {
        mRecyclerViewStudents = findViewById(R.id.recycler_view_student);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this);
        mRecyclerViewStudents.setLayoutManager(layoutManager);
    }
}