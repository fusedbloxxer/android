package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatetTimePickerFragment extends Fragment {
    private String mSelectedDate;
    private DatePickerListener mDatePickerListener;
    private CalendarView mCalendarView;
    private Button mButtonOk;

    public DatetTimePickerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View initView = inflater.inflate(R.layout.fragment_datet_time_picker, container, false);
        mDatePickerListener = (DatePickerListener) getActivity();
        mCalendarView = initView.findViewById(R.id.calendar_view);
        mButtonOk = initView.findViewById(R.id.button_ok);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mSelectedDate = dayOfMonth + "/" + month + "/" + year;
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerListener.sendData(mSelectedDate);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return initView;
    }
}
