package com.code_challenges.androiddeveloperfundamentals.week_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private CheckBox mCheckBoxTerms;
    private TextView mTextViewOutput;
    private Button mButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email);
        mEditTextPhone = findViewById(R.id.edit_text_phone);
        mCheckBoxTerms = findViewById(R.id.checkbox_terms);
        mTextViewOutput = findViewById(R.id.text_view_output);
        mButtonSubmit = findViewById(R.id.button_submit);
    }


    private boolean isEmailValid() {
        if (mEditTextEmail != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPhoneValid() {
        if (mEditTextPhone != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailAccepted() {
        if (isEmailValid()) {
            String email = mEditTextEmail.getText().toString();
            if (!email.isEmpty()) {
                Pattern pattern = Pattern.compile("^[0-9a-zA-Z.]+@[a-zA-Z]+\\.[a-zA-Z]+$");
                Matcher matcher = pattern.matcher(email);
                if (matcher.find()) {
                    return true;
                } else {
                    mEditTextEmail.setError("Invalid email address.");
                    return false;
                }
            } else {
                mEditTextEmail.setError("You have to enter an email address.");
                return false;
            }
        } else {
            Toast.makeText(LoginActivity.this, "EditTextEmail was not initialised.", Toast.LENGTH_LONG);
            return false;
        }
    }
    private boolean isPhoneAccepted() {
        if (isPhoneValid()) {
            String phone = mEditTextPhone.getText().toString();
            if (!phone.isEmpty()) {
                Pattern pattern = Pattern.compile("^\\d+$");
                Matcher matcher = pattern.matcher(phone);
                if (matcher.find()) {
                    return true;
                } else {
                    mEditTextPhone.setError("Invalid phone number.");
                    return false;
                }
            } else {
                mEditTextPhone.setError("You have to enter a phone number.");
                return false;
            }
        } else {
            Toast.makeText(LoginActivity.this, "EditTextPhone was not initialised.", Toast.LENGTH_LONG);
            return false;
        }
    }

    private boolean isChecked() {
        return mCheckBoxTerms.isChecked();
    }

    public void onClickSubmitData(View view) {
        if (isChecked()) {
            if (isEmailAccepted() && isPhoneAccepted()) {
                mTextViewOutput.setText("Email Address: " + mEditTextEmail.getText().toString() + "\n" +
                        "Phone: " + mEditTextPhone.getText().toString());
            }
        } else {
            mCheckBoxTerms.setError("You must agree to the Terms and Conditions.");
        }

    }
}
