package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CustomTimePickerDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), onTimeSetListener, hour, min, false);
    }

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @SuppressLint("NewApi")
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getActivity(), String.format("Time is: %02d:%02d",
                    hourOfDay, minute), Toast.LENGTH_SHORT).show();
        }
    };
}
