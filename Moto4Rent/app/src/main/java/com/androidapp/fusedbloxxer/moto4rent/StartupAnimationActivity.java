package com.androidapp.fusedbloxxer.moto4rent;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartupAnimationActivity extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    private int timeInMilliseconds = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_animation);
        startAnimation();
    }

    private void startAnimation() {
        countDownTimer = new CountDownTimer(timeInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent startLoginActivity = new Intent(StartupAnimationActivity.this, LoginActivity.class);
                startActivity(startLoginActivity);
                finish();
            }
        }.start();
    }
}
