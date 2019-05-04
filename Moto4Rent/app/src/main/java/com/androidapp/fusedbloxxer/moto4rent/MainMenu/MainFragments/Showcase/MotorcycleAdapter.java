package com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.Showcase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.List;
import java.util.Locale;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleViewHolder> {
    private List<Motorcycle> mMotorcycleList;
    private Context mContext;

    MotorcycleAdapter(List<Motorcycle> mMotorcycleList, Context parent) {
        this.mMotorcycleList = mMotorcycleList;
        this.mContext = parent;
    }

    @NonNull
    @Override
    public MotorcycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.motorcycle_item, viewGroup, false);

        return new MotorcycleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MotorcycleViewHolder motorcycleViewHolder, int i) {
        final Motorcycle motorcycle = mMotorcycleList.get(i);
        Integer integerValue;
        String stringValue;

        if (motorcycle != null) {
            integerValue = motorcycle.getIntValue(Motorcycle.KEY_IMAGE);

            if (integerValue != null) {
                motorcycleViewHolder
                        .getmImageViewDisplay()
                        .setImageResource(integerValue);
            }

            integerValue = motorcycle.getIntValue(Motorcycle.KEY_DEPOSIT);

            if (integerValue != null) {
                motorcycleViewHolder
                        .getmTextViewDeposit()
                        .setText(String.format(Locale.getDefault(),
                                "%s: %d euro",
                                mContext
                                        .getResources()
                                        .getString(R.string.deposit_sum),
                                integerValue));
            }

            integerValue = motorcycle.getIntValue(Motorcycle.KEY_START_PRICE);

            if (integerValue != null) {
                motorcycleViewHolder
                        .getmTextViewPrice()
                        .setText(String.format(Locale.getDefault(),
                                "%s: %d euro",
                                mContext
                                        .getResources()
                                        .getString(R.string.start_price),
                                integerValue));
            }

            integerValue = motorcycle.getIntValue(Motorcycle.KEY_LOOKING);

            if (integerValue != null) {
                motorcycleViewHolder
                        .getmTextViewLooking()
                        .setText(String.valueOf(integerValue));
            }

            stringValue = motorcycle.getStringValue(Motorcycle.KEY_MODEL);

            if (stringValue != null) {
                motorcycleViewHolder
                        .getmTextViewModel()
                        .setText(stringValue);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMotorcycleList.size();
    }
}
