package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.code_challenges.androiddeveloperfundamentals.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void openNavigationActivity(View view) {
        Intent intent = new Intent(this, SportsNavigationDrawerActivity.class);

        startActivity(intent);
    }
}
