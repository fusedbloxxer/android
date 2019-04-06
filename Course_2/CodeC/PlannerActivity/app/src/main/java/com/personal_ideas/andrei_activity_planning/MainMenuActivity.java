package com.personal_ideas.andrei_activity_planning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainMenuActivity extends AppCompatActivity {

    private ProgressBar mProgressBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mProgressBarLoading.setVisibility(View.GONE);
            }
        }).start();
    }

    private void initView() {
        mProgressBarLoading = findViewById(R.id.progress_bar);
    }
}
