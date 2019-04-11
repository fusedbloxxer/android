package com.code_challenges.traveljournal.PlanningList;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.code_challenges.traveljournal.IntentRequests;
import com.code_challenges.traveljournal.EditTripActivity;
import com.code_challenges.traveljournal.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTravelActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<TravelPlan> travelPlanList;

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view_travel);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void getDataSource() {
        travelPlanList = new ArrayList<>();

        // HARDCODED LIST
        travelPlanList.add(new TravelPlan.Builder().setmLocationName("Dubai")
                .setmTravelDateStart("Spring 2019")
                .setmTravelDateEnd("")
                .setmImageSource(R.drawable.underwater).build());
        travelPlanList.add(new TravelPlan.Builder().setmLocationName("East Asia")
                .setmTravelDateStart("Fall 2019")
                .setmTravelDateEnd("")
                .setmImageSource(R.drawable.east_asia).build());
        travelPlanList.add(new TravelPlan.Builder().setmLocationName("France")
                .setmTravelDateStart("Winter 2019")
                .setmTravelDateEnd("")
                .setmImageSource(R.drawable.france).build());
        travelPlanList.add(new TravelPlan.Builder().setmLocationName("Greece")
                .setmTravelDateStart("Spring 2020")
                .setmTravelDateEnd("")
                .setmImageSource(R.drawable.greece).build());
        travelPlanList.add(new TravelPlan.Builder().setmLocationName("Honolulu")
                .setmTravelDateStart("Summer 2020")
                .setmTravelDateEnd("")
                .setmImageSource(R.drawable.honolulu).build());
    }

    private void setAdapter() {
        mRecyclerView.setAdapter(new TravelPlanAdapter(travelPlanList));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == IntentRequests.ADD_TRAVEL_PLAN_REQUEST) {
            if (resultCode == RESULT_OK) {

                TravelPlan travelPlan = new TravelPlan.Builder()
                        .setmPrice(Integer.parseInt(data.getStringExtra(IntentRequests.TRIP_PRICE)))
                        .setmRating(Float.valueOf(data.getStringExtra(IntentRequests.TRIP_RATING)))
                        .setmTravelDateStart(data.getStringExtra(IntentRequests.TRIP_START_DATE))
                        .setmTravelDateEnd(data.getStringExtra(IntentRequests.TRIP_END_DATE))
                        .setmLocationName(data.getStringExtra(IntentRequests.TRIP_LOCATION))
                        .setmTripType(data.getStringExtra(IntentRequests.TRIP_TYPE))
                        .setmImageSource(R.drawable.algarve)
                        .build();

                travelPlanList.add(travelPlan);
                setAdapter();
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_travel);

        initView();
        setLayoutManager();
        getDataSource();
        setAdapter();
    }

    public void addTravelPlanOnClick(View view) {
        Intent addPlanIntent = new Intent(RecyclerViewTravelActivity.this, EditTripActivity.class);

        startActivityForResult(addPlanIntent, IntentRequests.ADD_TRAVEL_PLAN_REQUEST);
    }
}
