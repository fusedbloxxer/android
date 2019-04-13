package com.code_challenges.androiddeveloperfundamentals.week_5.ThirdCodeChallenge;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.solver.widgets.ConstraintWidgetGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class ChatFirstActivity extends AppCompatActivity {
    public static final int CHAT_SECOND_ACTIVITY = 1;
    public static final int CHAT_FIRST_ACTIVITY = 2;
    public static final String CHAT_MESSAGE = "chat_message";

    private ConstraintHelper mViewGroupChatBox;
    private EditText mEditTextMessage;
    private TextView mTextViewChatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_first);

        initView();
    }

    private void initView() {
        mEditTextMessage = findViewById(R.id.edit_text_first_message_box);
        mViewGroupChatBox = findViewById(R.id.first_chat_group);
        mTextViewChatBox = findViewById(R.id.text_view_chat_first);
    }

    public void onSendMessage(View view) {
        String message = mEditTextMessage.getText().toString();

        if (!message.isEmpty()) {
            Intent startSecondChat = new Intent(this, ChatSecondActivity.class);
            startSecondChat.putExtra(CHAT_MESSAGE, message);
            startActivityIfNeeded(startSecondChat, CHAT_SECOND_ACTIVITY);

        } else {
            mEditTextMessage.setError("Please add a message");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (mViewGroupChatBox.getVisibility() == View.GONE) {
                mViewGroupChatBox.setVisibility(View.VISIBLE);
            }
            mTextViewChatBox.setText(mTextViewChatBox.getText().toString() + "\n" + data.getStringExtra(CHAT_MESSAGE));
        }
    }
}
