package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportListFragment extends Fragment {
    private List<Sport> mSportList;
    private RecyclerView mRecyclerViewSport;

    public SportListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sport_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View container) {
        mRecyclerViewSport = container.findViewById(R.id.recycler_view_sport);

        setData();
        setLayoutManager();
        setAdapter();
    }

    private void setAdapter() {
        mRecyclerViewSport.setAdapter(new SportAdapter(getContext(), mSportList));
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewSport.setLayoutManager(layoutManager);
    }

    private void setData() {
        mSportList = new ArrayList<>();
        mSportList.add(new Sport(R.drawable.android_1, "Archery", 9, 23, "Sambdodromo"));
        mSportList.add(new Sport(R.drawable.android_2, "Athletics", 11, 15, "Olympic Stadiun"));
        mSportList.add(new Sport(R.drawable.android_3, "Fencing", 10, 13, "Carioca Arena 3"));
        mSportList.add(new Sport(R.drawable.android_5, "Gymnastics", 14, 16, "Rio Olympic Arena"));
    }
}
