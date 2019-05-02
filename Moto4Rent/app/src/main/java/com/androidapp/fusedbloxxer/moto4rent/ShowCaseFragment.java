package com.androidapp.fusedbloxxer.moto4rent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowCaseFragment extends Fragment {
    private RecyclerView mRecyclerView;

    public ShowCaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_show_case, container, false);
        initView(itemView);

        return itemView;
    }

    private void initView(View itemView) {
        mRecyclerView = itemView.findViewById(R.id.recycler_view_showcase);
    }

}
