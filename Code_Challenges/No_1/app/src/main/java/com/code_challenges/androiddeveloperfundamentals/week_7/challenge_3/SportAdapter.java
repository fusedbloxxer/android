package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportViewHolder> {
    private List<Sport> mSportList;
    private Context mParentContext;

    SportAdapter(Context mContext, List<Sport> sportList) {
        this.mParentContext = mContext;
        this.mSportList = sportList;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.list_item_sport, viewGroup, false);

        return new SportViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder sportViewHolder, int i) {
        Sport sport = mSportList.get(i);

        if (sport != null) {
            sportViewHolder
                    .getmImageViewSport()
                    .setImageResource(sport.getImageResourceID());
            sportViewHolder
                    .setmImageResourceID(sport.getImageResourceID());

            if (sport.getLocation() != null) {
                sportViewHolder
                        .getmTextViewSportLocation()
                        .setText(sport.getLocation());
            }
            if (sport.getPeriod() != null) {
                sportViewHolder
                        .getmTextViewSportPeriod()
                        .setText(sport.getPeriod());
            }
            if (sport.getSportName() != null) {
                sportViewHolder
                        .getmTextViewSportName()
                        .setText(sport.getSportName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mSportList.size();
    }
}
