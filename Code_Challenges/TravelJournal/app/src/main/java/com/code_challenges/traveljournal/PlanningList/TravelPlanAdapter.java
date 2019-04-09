package com.code_challenges.traveljournal.PlanningList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.code_challenges.traveljournal.R;

import java.util.List;

public class TravelPlanAdapter extends RecyclerView.Adapter<TravelPlanViewHolder> {
    private List<TravelPlan> mTravelPlanList;

    TravelPlanAdapter(List<TravelPlan> travelPlans) {
        mTravelPlanList = travelPlans;
    }

    @NonNull
    @Override
    public TravelPlanViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.travel_plan_view, viewGroup, false);

        final TravelPlanViewHolder travelPlanViewHolder = new TravelPlanViewHolder(itemView);

        return travelPlanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TravelPlanViewHolder travelPlanViewHolder, int i) {
        final TravelPlan currentElement = mTravelPlanList.get(i);

        if (currentElement != null) {
            travelPlanViewHolder.getmImageViewLocation().setImageResource(currentElement.getmImageSource());
            if (currentElement.getmLocationName() != null) {
                travelPlanViewHolder.getmTextViewTravelLocation().setText(currentElement.getmLocationName());
            }
            if (currentElement.getmTravelDate() != null) {
                travelPlanViewHolder.getmTextViewTravelDate().setText(currentElement.getmTravelDate());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mTravelPlanList.size();
    }
}
