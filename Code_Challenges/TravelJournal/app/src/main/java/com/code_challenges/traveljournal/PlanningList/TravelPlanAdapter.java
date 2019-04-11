package com.code_challenges.traveljournal.PlanningList;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return new TravelPlanViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TravelPlanViewHolder travelPlanViewHolder, int i) {
        TravelPlan currentElement = mTravelPlanList.get(i);

        if (currentElement != null) {

            travelPlanViewHolder
                    .getmRatingBarTravel()
                    .setRating(currentElement.getmRating());

            travelPlanViewHolder
                    .getmImageViewLocation()
                    .setImageResource(currentElement.getmImageSource());

            if (currentElement.getmLocationName() != null) {
                travelPlanViewHolder
                        .getmTextViewTravelLocation()
                        .setText(currentElement.getmLocationName());
            }
            if (currentElement.getmTravelDateStart() != null
                    && currentElement.getmTravelDateEnd() != null) {
                travelPlanViewHolder
                        .getmTextViewTravelDate()
                        .setText(currentElement.getmTravelDateStart() + " "
                                + currentElement.getmTravelDateEnd());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mTravelPlanList.size();
    }
}
