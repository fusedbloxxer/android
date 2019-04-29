package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

public class SportDetailsActivity extends AppCompatActivity {
    private ImageView mImageViewSport, mImageViewBackground, mImageViewParticipant,
                      mImageViewSport1, mImageViewSport2;
    private TextView mTextViewSportName, mTextViewSportPeriod, mTextViewSportLocation,
                     mTextViewSportName1, mTextViewSportName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_details);

        initView();
    }

    private void initView() {
        mImageViewSport = findViewById(R.id.image_view_sport);
        mTextViewSportName = findViewById(R.id.text_view_sport_name);
        mTextViewSportName1 = findViewById(R.id.text_view_sport_name);
        mTextViewSportName2 = findViewById(R.id.text_view_sport_name);
        mTextViewSportLocation = findViewById(R.id.text_view_sport_location);
        mTextViewSportPeriod = findViewById(R.id.text_view_sport_period);
        mImageViewBackground = findViewById(R.id.image_view_background);
        mImageViewParticipant = findViewById(R.id.image_view_participant);
        mImageViewSport1 = findViewById(R.id.image_view_sport_1);
        mImageViewSport2 = findViewById(R.id.image_view_sport_2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mImageViewSport.setImageResource(bundle.getInt("sport_image"));
            mImageViewSport1.setImageResource(bundle.getInt("sport_image"));
            mImageViewSport2.setImageResource(bundle.getInt("sport_image"));
            mImageViewParticipant.setImageResource(bundle.getInt("sport_image"));
            mTextViewSportName.setText(bundle.getString("sport_name"));
            mTextViewSportName1.setText(bundle.getString("sport_name"));
            mTextViewSportName2.setText(bundle.getString("sport_name"));
            mTextViewSportLocation.setText(bundle.getString("sport_location"));
            mTextViewSportPeriod.setText(bundle.getString("sport_period"));
        } else {
            Toast.makeText(this, "No extras received !", Toast.LENGTH_LONG).show();
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
