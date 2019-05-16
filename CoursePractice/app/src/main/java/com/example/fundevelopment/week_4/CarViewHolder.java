package com.example.fundevelopment.week_4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.fundevelopment.R;

public class CarViewHolder extends RecyclerView.ViewHolder {

    public TextView getmTextViewName() {
        return mTextViewName;
    }

    public TextView getmTextViewColor() {
        return mTextViewColor;
    }

    public TextView getmTextViewHp() {
        return mTextViewHp;
    }

    private TextView mTextViewName;
    private TextView mTextViewColor;
    private TextView mTextViewHp;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewName = itemView.findViewById(R.id.text_view_name);
        mTextViewColor = itemView.findViewById(R.id.text_view_color);
        mTextViewHp = itemView.findViewById(R.id.text_view_hp);
    }
}