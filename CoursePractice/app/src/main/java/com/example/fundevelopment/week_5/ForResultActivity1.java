package com.example.fundevelopment.week_5;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fundevelopment.R;

public class ForResultActivity1 extends AppCompatActivity {
    public static final String NAME = "name";
    public static final int FIRST_ACTIVITY = 7;
    public static final String INPUT_VALUE = "edittext";
    public static final String CHECKBOX_VALUE = "checkbox";

    private EditText mEditTextName;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result1);

        initView();
    }

    private void initView() {
        mEditTextName = findViewById(R.id.edit_text_name);
        mCheckBox = findViewById(R.id.checkBox);
    }

    public void sendNameToSecondActivityOnClick(View view) {
        if (mEditTextName != null && mEditTextName.getText() != null) {
            String name = mEditTextName.getText().toString();
            //TextUtils.isEmpty(name)

            if (!name.isEmpty()) {
                Intent startSecondActivityIntent = new Intent(ForResultActivity1.this,
                        ForResultActivity2.class);
                startSecondActivityIntent.putExtra(NAME, name);
                startActivityForResult(startSecondActivityIntent, FIRST_ACTIVITY);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FIRST_ACTIVITY
                && resultCode == RESULT_OK) {
            if (data != null) {
                String name = data.getStringExtra(NAME);
                mEditTextName.setText(name);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mEditTextName != null && mEditTextName.getText().toString() != null) {
            outState.putString(INPUT_VALUE, mEditTextName.getText().toString());
        }
        if (mCheckBox != null) {
            outState.putBoolean(CHECKBOX_VALUE, mCheckBox.isChecked());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String text = savedInstanceState.getString(INPUT_VALUE);
            Boolean check = savedInstanceState.getBoolean(CHECKBOX_VALUE);

            if (mEditTextName != null && !TextUtils.isEmpty(text)) {
                mEditTextName.setText(text);
            }

            if (mCheckBox != null) {
                mCheckBox.setChecked(check);
            }
        }
    }

    public void startDebugActivityOnClick(View view) {
        Intent intent = new Intent(ForResultActivity1.this, DebugActivity.class);
        startActivity(intent);
    }
}
