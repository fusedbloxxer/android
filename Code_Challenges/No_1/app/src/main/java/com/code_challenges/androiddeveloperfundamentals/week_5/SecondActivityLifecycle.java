package com.code_challenges.androiddeveloperfundamentals.week_5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.code_challenges.androiddeveloperfundamentals.R;

public class SecondActivityLifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lifecycle);

        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onCreate - The activity was created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onStart - The activity has started.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onResume - The activity has resumed.");
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onPause - The activity has paused.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onStop - The activity has stopped.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onRestart - The activity has restarted.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(SecondActivityLifecycle.class.getSimpleName(), "onDestroy - The activity has been destroyed.");
    }

    public void startFirstActivityOnClick(View view) {
        Intent startFirstActivity = new Intent(SecondActivityLifecycle.this, FirstActivityLifecycle.class);

        // FLAG ACTIVITY to be reordered to the front by setting the flag.
        startFirstActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(startFirstActivity, 0);
    }
}
