package com.code_challenges.androiddeveloperfundamentals.week_5.FirstCodeChallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.code_challenges.androiddeveloperfundamentals.R;

public class FirstActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_lifecycle);
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onCreate - The activity has been created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onStart - The activity started (is visible).");
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onResume - The activity has resumed.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onPause - The activity has paused.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onRestart - The activity his restarting.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onStop - The activity has stopped.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(FirstActivityLifecycle.class.getSimpleName(), "onDestroy - The activity was destroyed.");
    }

    public void startSecondActivityOnClick(View view) {
        Intent secondActivity = new Intent(FirstActivityLifecycle.this, SecondActivityLifecycle.class);

        secondActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(secondActivity, 0);
    }
}
