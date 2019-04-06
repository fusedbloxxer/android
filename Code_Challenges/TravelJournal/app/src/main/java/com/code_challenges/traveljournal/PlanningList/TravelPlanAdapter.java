package com.code_challenges.traveljournal.PlanningList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.code_challenges.traveljournal.R;

import java.util.List;

public class TravelPlanAdapter extends RecyclerView.Adapter<TravelPlanViewHolder> {
    private List<TravelPlan> mTravelPlanList;

    public void addTravelPlan(TravelPlan travelPlan) {
        mTravelPlanList.add(travelPlan);
    }

    public List<TravelPlan> getmTravelPlanList() {
        return mTravelPlanList;
    }

    TravelPlanAdapter(List<TravelPlan> travelPlans) {
        mTravelPlanList = travelPlans;
    }

    @NonNull
    @Override
    public TravelPlanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.travel_plan_view, viewGroup, false);

        return new TravelPlanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelPlanViewHolder travelPlanViewHolder, int i) {
        TravelPlan currentElement = mTravelPlanList.get(i);

        if (currentElement != null) {
            travelPlanViewHolder.getmImageViewLocation().setImageResource(currentElement.getmImageSource());
            if (currentElement.getmLocationName() != null) {
                travelPlanViewHolder.getmTextViewTravelLocation().setText(currentElement.getmLocationName());
            }
            if (currentElement.getmTravelDate() != null) {
                travelPlanViewHolder.getmTextViewTravelDate().setText(currentElement.getmTravelDate());
            }
            travelPlanViewHolder.getmImageViewLocation().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.setFocusable(true);
                            break;
                        case MotionEvent.ACTION_UP:
                            v.setFocusable(false);
                            break;
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mTravelPlanList.size();
    }
}
