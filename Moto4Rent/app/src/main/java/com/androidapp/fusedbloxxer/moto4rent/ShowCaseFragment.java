package com.androidapp.fusedbloxxer.moto4rent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowCaseFragment extends Fragment {
    private List<Motorcycle> mMotorcycleList;
    private RecyclerView mRecyclerView;

    public ShowCaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_show_case, container, false);
        initView(itemView);
        setData();
        setLayoutManager();
        setAdapter();

        return itemView;
    }

    private void setAdapter() {
        mRecyclerView.setAdapter(new MotorcycleAdapter(mMotorcycleList, getActivity()));
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void setData() {
        // TODO: Preluare din baza de date a informatiilor despre motociclete.
        if (mMotorcycleList == null) {
            mMotorcycleList = new ArrayList<>();
        }

        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Suzuki GS500E - 1997", "Naked bike",
                        "A", R.drawable.moto_display_suzuki_gs500e,
                        300, 22, false)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Suzuki SV650N - 1999", "Naked bike",
                        "A", R.drawable.moto_display_suzuki_sv640n,
                        400, 27, false)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Kawasaki ZR7 - 2002", "Allround",
                        "A", R.drawable.moto_display_kawasaki_zr7,
                        400, 32, false)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Honda CB600S Hornet - 2001", "Allround",
                        "A", R.drawable.moto_display_cb600s,
                        400, 32, true)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Yamaha SuperTenere - 1997", "Allround",
                        "A", R.drawable.moto_display_yamaha_supertenere,
                        500 , 35, true)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Kawasaki ZX-6R - 2006", "Allround",
                        "A", R.drawable.moto_display_kawasaki_zx_6r,
                        600  , 53, true)
                        .build());
        mMotorcycleList
                .add(new Motorcycle.MotorcycleBuilder("Yamaha YZF-R6 - 2005", "Allround",
                        "A", R.drawable.moto_display_yamaha_yzf_r6,
                        700   , 60, true)
                        .build());
    }

    private void initView(View itemView) {
        mRecyclerView = itemView.findViewById(R.id.recycler_view_showcase);
    }
}
