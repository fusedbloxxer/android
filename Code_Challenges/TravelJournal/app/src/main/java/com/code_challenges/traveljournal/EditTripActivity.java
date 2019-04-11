package com.code_challenges.traveljournal;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class EditTripActivity extends AppCompatActivity {
    private EditText mEditTextTripLocation, mEditTextTripName;
    private Button mButtonStartDate, mButtonEndDate;
    private RadioGroup mRadioGroupTripType;
    private TextView mTextViewTripPrice;
    private SeekBar mSeekBarTripPrice;
    private RatingBar mRatingBarTrip;


    private void initView() {
        mRadioGroupTripType = findViewById(R.id.radio_group_trip_type);
        mEditTextTripName = findViewById(R.id.edit_text_trip_name);
        mEditTextTripLocation = findViewById(R.id.edit_text_trip_location);
        mButtonEndDate = findViewById(R.id.button_date_end);
        mButtonStartDate = findViewById(R.id.button_date_start);
        mSeekBarTripPrice = findViewById(R.id.seek_bar_travel_price);
        mTextViewTripPrice = findViewById(R.id.price_tag);
        mRatingBarTrip = findViewById(R.id.rating_bar_trip_stars);
    }

    private void setViews() {
        mTextViewTripPrice.setText("Price(" + mSeekBarTripPrice.getProgress() + ")");
        mSeekBarTripPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextViewTripPrice.setText("Price(" + progress + ")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == IntentRequests.DATE_PICKER_START) {
                mButtonStartDate.setText(data.getStringExtra(IntentRequests.DATE));
            } else if (requestCode == IntentRequests.DATE_PICKER_END) {
                mButtonEndDate.setText(data.getStringExtra(IntentRequests.DATE));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setViews();
    }

    public void submitTripDataOnClick(View view) {
        if (isEditTextValid(mEditTextTripName, mEditTextTripLocation)
                && isDateValid(mButtonStartDate, mButtonEndDate)
                && isRadioGroupValid(mRadioGroupTripType)) {

            String tripType = "";
            switch (mRadioGroupTripType.getCheckedRadioButtonId()) {
                case 0:
                    tripType = "City break";
                    break;
                case 1:
                    tripType = "Sea side";
                    break;
                case 2:
                    tripType = "Mountains";
                    break;
            }

            Intent submitDataIntent = new Intent();
            submitDataIntent.putExtra(IntentRequests.TRIP_PRICE, String.valueOf(mSeekBarTripPrice.getProgress()));
            submitDataIntent.putExtra(IntentRequests.TRIP_LOCATION, mEditTextTripLocation.getText().toString());
            submitDataIntent.putExtra(IntentRequests.TRIP_RATING, String.valueOf(mRatingBarTrip.getRating()));
            submitDataIntent.putExtra(IntentRequests.TRIP_START_DATE, mButtonStartDate.getText().toString());
            submitDataIntent.putExtra(IntentRequests.TRIP_END_DATE, mButtonEndDate.getText().toString());
            submitDataIntent.putExtra(IntentRequests.TRIP_NAME, mEditTextTripName.getText().toString());
            submitDataIntent.putExtra(IntentRequests.TRIP_TYPE, tripType);

            setResult(RESULT_OK, submitDataIntent);
            finish();
        }
    }

    public void addStartDateOnClick(View view) {
        Intent startCalendar = new Intent(EditTripActivity.this, DatePickerActivity.class);

        startCalendar.putExtra(IntentRequests.BUTTON_DATE_PICKER, view.getTag().toString());

        startActivityForResult(startCalendar, IntentRequests.DATE_PICKER_START);
    }

    public void addEndDateOnClick(View view) {
        Intent startCalendar = new Intent(EditTripActivity.this, DatePickerActivity.class);

        startCalendar.putExtra(IntentRequests.BUTTON_DATE_PICKER, view.getTag().toString());

        startActivityForResult(startCalendar, IntentRequests.DATE_PICKER_END);
    }

    private boolean isDateValid(Button... button) {
        if (button != null) {
            for (int i = 0; i < button.length; i++) {
                if (button[i] != null) {
                    if (button[i].getText().toString().startsWith("DD/MM/YYYY")) {
                        Toast.makeText(this, "No date selected.", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                } else {
                    return false;
                }
            }

            String[] startDate = button[0].getText().toString().split("/");
            String[] endDate = button[1].getText().toString().split("/");

            if (Integer.parseInt(startDate[2]) > Integer.parseInt(endDate[2])) {
                Toast.makeText(this, "The start date musn't be after the last day.", Toast.LENGTH_SHORT).show();
                return false;

            } else if (Integer.parseInt(startDate[2]) == Integer.parseInt(endDate[2])) {

                if (Integer.parseInt(startDate[1]) > Integer.parseInt(endDate[1])) {
                    Toast.makeText(this, "The start date musn't be after the last day.", Toast.LENGTH_SHORT).show();
                    return false;

                } else if (Integer.parseInt(startDate[1]) == Integer.parseInt(endDate[1])) {

                    if (Integer.parseInt(startDate[0]) > Integer.parseInt(endDate[0])) {
                        Toast.makeText(this, "The start date musn't be after the last day.", Toast.LENGTH_SHORT).show();

                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    private boolean isRadioGroupValid(RadioGroup radioGroup) {
        if (radioGroup != null) {
            int selectedRadioButtonID = radioGroup.getCheckedRadioButtonId();
            if (selectedRadioButtonID != -1) {
                return true;
            } else {
                Toast.makeText(this, "You have to select the trip type !", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    private boolean isEditTextValid(EditText... editText) {
        if (editText != null) {
            for (int i = 0; i < editText.length; i++) {
                if (editText[i] != null) {
                    if (editText[i].getText().toString().isEmpty()) {
                        editText[i].setError(IntentRequests.ERROR_EMPTY_STRING);
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}
