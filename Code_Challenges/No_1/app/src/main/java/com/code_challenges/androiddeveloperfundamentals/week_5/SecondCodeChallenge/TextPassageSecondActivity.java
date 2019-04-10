package com.code_challenges.androiddeveloperfundamentals.week_5.SecondCodeChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

import static com.code_challenges.androiddeveloperfundamentals.week_5.SecondCodeChallenge.TextPassageFirstActivity.PASSAGE_ID;

public class TextPassageSecondActivity extends AppCompatActivity {
    private TextView mTextViewPassage;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_passage_second);

        initView();
        mTextViewPassage.setText(bundle.getString(PASSAGE_ID));
    }

    private void initView() {
        bundle = getIntent().getExtras();
        mTextViewPassage = findViewById(R.id.text_view_passage);
    }
}
