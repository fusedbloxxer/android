package com.code_challenges.traveljournal.PlanningList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.code_challenges.traveljournal.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTravelActivity extends AppCompatActivity {

    private TravelPlanAdapter mTravelPlanAdapter;
    private RecyclerView mRecyclerView;
    private List<TravelPlan> travelPlanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_travel);

        initView();
        setLayoutManager();
        getDataSource();
        setAdapter();
        mTravelPlanAdapter.getmTravelPlanList().remove(0);
    }

    private void setAdapter() {
        mTravelPlanAdapter = new TravelPlanAdapter(travelPlanList);
        mRecyclerView.setAdapter(mTravelPlanAdapter);
    }

    private void getDataSource() {
        travelPlanList = new ArrayList<>();

        travelPlanList.add(new TravelPlan("Spring 2019", "Algarve", R.drawable.underwater));
        travelPlanList.add(new TravelPlan("Summer 2019", "Dubai", R.drawable.dubai));
        travelPlanList.add(new TravelPlan("Fall 2019", "East Asia", R.drawable.east_asia));
        travelPlanList.add(new TravelPlan("Winter 2019", "France", R.drawable.france));
        travelPlanList.add(new TravelPlan("Spring 2020", "Greece", R.drawable.greece));
        travelPlanList.add(new TravelPlan("Summer 2020", "Honolulu", R.drawable.honolulu));
        travelPlanList.add(new TravelPlan("Fall 2020", "India", R.drawable.india));
        travelPlanList.add(new TravelPlan("Winter 2020", "Italy", R.drawable.italy));
        travelPlanList.add(new TravelPlan("Spring 2021", "Maldive", R.drawable.maldive));
        travelPlanList.add(new TravelPlan("Summer 2021", "Orlando", R.drawable.orlando));
        travelPlanList.add(new TravelPlan("Fall 2021", "Underwater", R.drawable.underwater));
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view_travel);
    }
}
