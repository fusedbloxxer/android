package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_4.varianta_2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.week_7.challenge_4.DatePickerListener;

import java.util.Calendar;

public class CustomDatePickerDialog extends DialogFragment {
    private DatePickerListener mDatePickerListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        mDatePickerListener = (DatePickerListener) getActivity();

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String sendDate = "The selected date is: " + view.getDayOfMonth() +
                    "/" + (view.getMonth() + 1) +
                    "/" + view.getYear();
            Toast.makeText(getActivity(), sendDate, Toast.LENGTH_SHORT).show();
            mDatePickerListener.sendData(sendDate);
        }
    };
}
