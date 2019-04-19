package com.code_challenges.androiddeveloperfundamentals.week_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.code_challenges.androiddeveloperfundamentals.R;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
    }

    public void startNextActivity(View view) {
        Intent intent = new Intent(FrameLayoutActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
