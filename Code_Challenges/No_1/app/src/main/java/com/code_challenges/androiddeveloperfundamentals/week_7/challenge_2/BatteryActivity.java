package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_2;

import android.graphics.drawable.LevelListDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class BatteryActivity extends AppCompatActivity {
    private int mCurrentLevel;
    private ImageView mImageViewBattery;
    private Button mButtonIncreaseBattery, mButtonDecreaseBattery;
    private LevelListDrawable mLevelListDrawableBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        initView();
    }

    private void initView() {
        mCurrentLevel = 0;
        mImageViewBattery = findViewById(R.id.image_view_battery);
        mButtonDecreaseBattery = findViewById(R.id.button_decrease_battery);
        mButtonIncreaseBattery = findViewById(R.id.button_increase_battery);

        mImageViewBattery.setBackgroundResource(R.drawable.resource_battery);
        mLevelListDrawableBattery = (LevelListDrawable) mImageViewBattery.getBackground();
    }

    public void decreaseBatteryOnClick(View view) {
        if (mCurrentLevel > 0) {
            mLevelListDrawableBattery.setLevel(--mCurrentLevel);
        }
    }

    public void increaseBatteryOnClick(View view) {
        if (mCurrentLevel < 7) {
            mLevelListDrawableBattery.setLevel(++mCurrentLevel);
        }
    }
}
