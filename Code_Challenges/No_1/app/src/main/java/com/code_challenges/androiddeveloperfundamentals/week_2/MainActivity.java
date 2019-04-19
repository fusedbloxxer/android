package com.code_challenges.androiddeveloperfundamentals.week_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_3.FrameLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
        startActivity(intent);
    }
}