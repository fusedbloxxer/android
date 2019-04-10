package com.code_challenges.androiddeveloperfundamentals.week_5.SecondCodeChallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.code_challenges.androiddeveloperfundamentals.R;

public class TextPassageFirstActivity extends AppCompatActivity {
    public static final String PASSAGE_ID = "TEXT_PASSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_passage_first);

    }

    public void openTextActivityOnClick(View view) {
        Intent secondActivityIntent = new Intent(TextPassageFirstActivity.this, TextPassageSecondActivity.class);

        secondActivityIntent.putExtra(PASSAGE_ID, view.getTag().toString());
        secondActivityIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivityIfNeeded(secondActivityIntent, 0);
    }
}
