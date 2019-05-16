package com.example.fundevelopment.week_6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fundevelopment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {
    private TextView mTextViewSum;
    private int mFirtNumber, mSecondNumber;

    public SumFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sum, container, false);
        initView(view);
        bundleVersion();

        return view;
    }

    private void bundleVersion() {
        Bundle receivedParams = getArguments();
        int firstNumber = receivedParams.getInt(SumActivity.FIRST_NUMBER);
        int secondNumber = receivedParams.getInt(SumActivity.SECOND_NUMBER);
        // mTextViewSum.setText("Sum = " + firstNumber + secondNumber);
        methodVersion();
    }

    private void methodVersion() {
        int sum = mFirtNumber + mSecondNumber;
        mTextViewSum.setText("Sum = " + sum);
    }

    private void initView(View view) {
        mTextViewSum = view.findViewById(R.id.text_view_sum);
    }

    public void setmFirtNumber(int mFirtNumber) {
        this.mFirtNumber = mFirtNumber;
    }

    public void setmSecondNumber(int mSecondNumber) {
        this.mSecondNumber = mSecondNumber;
    }
}
