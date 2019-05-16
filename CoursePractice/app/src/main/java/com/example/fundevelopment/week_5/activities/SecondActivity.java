package com.example.fundevelopment.week_5.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fundevelopment.R;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewMessageReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle dataReceived = getIntent().getExtras();
        String message = dataReceived.getString(FirstActivity.MESSAGE);
        String messageReceived = getIntent().getExtras().getString(FirstActivity.MESSAGE);
        mTextViewMessageReceived.setText(message);
    }

    private void initView() {
        mTextViewMessageReceived = findViewById(R.id.text_view_message_received);
    }
}
