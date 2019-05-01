package com.androidapp.fusedbloxxer.moto4rent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends AppCompatActivity {
    private static final int INTENT_REQUEST_TERMS = 1;

    private EditText mEditTextEmail, mEditTextPass;
    private CheckBox mCheckBoxTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email_address);
        mEditTextPass = findViewById(R.id.edit_text_password);
        mCheckBoxTerms = findViewById(R.id.checkbox_terms_and_conditions);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openTermsAndConditionsOnClick(View view) {
        Intent termsAndConditions = new Intent(RegisterUserActivity.this, TermsAndConditionsActivity.class);
        startActivityForResult(termsAndConditions, INTENT_REQUEST_TERMS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case INTENT_REQUEST_TERMS: {
                if (resultCode != RESULT_OK) {
                    mCheckBoxTerms.setChecked(false);
                    Toast
                            .makeText(this,
                                    getResources().getString(R.string.error_tos),
                                    Toast.LENGTH_LONG)
                            .show();
                } else {
                    mCheckBoxTerms.setChecked(true);
                }
            }
            break;
        }
    }

    public void submitNewUserOnClick(View view) {
        if (LoginChecker
                .getInstance()
                .validLogin(this, mEditTextEmail, mEditTextPass)) {
            if (mCheckBoxTerms.isChecked()) {
                setResult(RESULT_OK);
                // TODO: Submit new user to data base.
                this.finish();
            } else {
                Toast
                        .makeText(this,
                                getResources().getString(R.string.error_tos),
                                Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
