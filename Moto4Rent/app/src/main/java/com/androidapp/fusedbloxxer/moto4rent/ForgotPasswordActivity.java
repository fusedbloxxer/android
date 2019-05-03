package com.androidapp.fusedbloxxer.moto4rent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ForgotPasswordActivity extends AbstractPortraitActivity {
    private EditText mEditTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email_address);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void recoverPasswordOnClick(View view) {
        if (LoginChecker
                .getInstance()
                .isEmailAccepted(this, mEditTextEmail)) {
            // TODO: Send Email Request.
            setResult(RESULT_OK);
            this.finish();
        } else {

        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
