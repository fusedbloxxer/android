package com.personal_ideas.andrei_activity_planning.PlannerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.personal_ideas.andrei_activity_planning.R;

public class PlannerForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_form);
    }

    public void onClickOpenScheduler(View view) {
        setContentView(R.layout.activity_scheduler);
    }
}
