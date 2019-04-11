package com.code_challenges.traveljournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class DatePickerActivity extends AppCompatActivity {
    private CalendarView mCalendarView;
    private String currentDate;
    private Button mButtonDate;
    private String dateType;

    private void initView() {
        dateType = getIntent().getStringExtra(IntentRequests.BUTTON_DATE_PICKER);
        mCalendarView = findViewById(R.id.calendarView);
        mButtonDate = findViewById(R.id.button_choose_date);
        mButtonDate.setText(String.format("Choose %s date.", dateType));
    }

    private void setViews() {
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                currentDate = dayOfMonth + "/" + month + "/" + year;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        initView();
        setViews();
    }

    public void chooseDateOnClick(View view) {
        Intent datePickerIntent = new Intent();

        datePickerIntent.putExtra(IntentRequests.DATE, currentDate);

        setResult(RESULT_OK, datePickerIntent);
        finish();
    }
}
