package com.example.fundevelopment.week_5.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fundevelopment.R;

public class FirstActivity extends AppCompatActivity {
    public static final String MESSAGE = "message";
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();
    }

    private void initView() {
        mEditTextMessage = findViewById(R.id.edit_text_message);
    }

    public void startSecondActivityOnClick(View view) {
        Intent goToSecondActivity = new Intent(FirstActivity.this,
                SecondActivity.class);
        startActivity(goToSecondActivity);
    }

    public void callImplicitIntentOnClick(View view) {
        Intent callAction = new Intent(Intent.ACTION_DIAL);
        callAction.setData(Uri.parse("tel:0777777777"));
        if (callAction.resolveActivity(getPackageManager()) != null) {
            startActivity(callAction);
        }
    }

    public void sendMessageOnClick(View view) {
        String message = mEditTextMessage.getText().toString();
        Intent sendMessage = new Intent(FirstActivity.this, SecondActivity.class);

        sendMessage.putExtra(MESSAGE, message);

        startActivity(sendMessage);
    }
}
