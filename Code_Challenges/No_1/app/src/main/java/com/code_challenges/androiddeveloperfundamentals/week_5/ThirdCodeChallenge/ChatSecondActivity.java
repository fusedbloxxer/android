package com.code_challenges.androiddeveloperfundamentals.week_5.ThirdCodeChallenge;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_5.FirstCodeChallenge.FirstActivityLifecycle;

public class ChatSecondActivity extends AppCompatActivity {
    private EditText mEditTextMessage;
    private TextView mTextViewChatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_second);

        initView();
        mTextViewChatBox.setText(mTextViewChatBox.getText().toString() + "\n" + getIntent().getStringExtra(ChatFirstActivity.CHAT_MESSAGE));
    }

    private void initView() {
        mEditTextMessage = findViewById(R.id.edit_text_second_message_box);
        mTextViewChatBox = findViewById(R.id.text_view_chat_second);
    }

    public void onSendMessage(View view) {
        String message = mEditTextMessage.getText().toString();

        if(!message.isEmpty()) {
            Intent resultIntent = new Intent(this, ChatFirstActivity.class);
            resultIntent.putExtra(ChatFirstActivity.CHAT_MESSAGE, message);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            mEditTextMessage.setText("Please add a message");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            mTextViewChatBox.setText(mTextViewChatBox.getText().toString() + "\n" + data.getStringExtra(ChatFirstActivity.CHAT_MESSAGE));
        }
    }
}
