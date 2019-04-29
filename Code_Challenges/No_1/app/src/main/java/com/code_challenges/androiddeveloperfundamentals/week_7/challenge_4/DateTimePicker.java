package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_4;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_7.challenge_4.varianta_2.CustomDatePickerDialog;

import java.util.Calendar;

public class DateTimePicker extends AppCompatActivity implements DatePickerListener {
    private TextView mTextViewDate;
    private DatePickerDialog mDatePickerDialog;
    private Calendar mCalendar;
    private String mSelectedDate;
    private CalendarView mCalendarView;
    private Button mButtonOk, mButtonLeft, mButtonRight;
    private Dialog mDialog;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        initView();
    }

    private void initView() {
        mCalendar = Calendar.getInstance();
        mTextViewDate = findViewById(R.id.text_view_date);
        mDatePickerDialog = new DatePickerDialog(DateTimePicker.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mTextViewDate.setText(dayOfMonth + "/" + month + "/" + year);
            }
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));


        alertDialog = new AlertDialog.Builder(DateTimePicker.this);
        View itemView = getLayoutInflater().inflate(R.layout.fragment_datet_time_picker, null);

        mCalendarView = itemView.findViewById(R.id.calendar_view);
        mButtonOk = itemView.findViewById(R.id.button_ok);
        mButtonLeft = itemView.findViewById(R.id.left_arrow);
        mButtonRight = itemView.findViewById(R.id.right_arrow);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                mSelectedDate = dayOfMonth + "/" + ++month + "/" + year;
            }
        });

        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(mSelectedDate);
                mDialog.cancel();
            }
        });

        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        alertDialog.setView(itemView);
        mDialog = alertDialog.create();
    }

    public void openDateTimePickerOnClick(View view) {
        DialogFragment dialogFragment = new CustomDatePickerDialog();
        dialogFragment.show(getSupportFragmentManager(), "DatePicker");

        // mDialog.show();

        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new DatetTimePickerFragment());
        fragmentTransaction.addToBackStack("date_picker");
        fragmentTransaction.commit();
        */

        // mDatePickerDialog.show();
    }

    @Override
    public void sendData(String date) {
        mTextViewDate.setText(date);
    }
}
