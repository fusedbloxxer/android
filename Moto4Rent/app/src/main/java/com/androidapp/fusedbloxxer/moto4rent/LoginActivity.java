package com.androidapp.fusedbloxxer.moto4rent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static final int INTENT_REQUEST_TERMS_AND_CONDITIONS = 1;
    private int mBackPresses;

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBackPresses = 0;
        mEditTextEmail = findViewById(R.id.edit_text_email_address);
        mEditTextPassword = findViewById(R.id.edit_text_password);
        mButtonLogin = findViewById(R.id.button_login);
    }

    private boolean isPasswordValid() {
        if (mEditTextPassword != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordAccepted() {
        if (isPasswordValid()) {
            String password = mEditTextPassword.getText().toString();
            if (password.length() > 4) {
                Pattern upperCase = Pattern.compile("[A-Z]");
                Pattern lowerCase = Pattern.compile("[a-z]");
                Pattern digit = Pattern.compile("[0-9]");
                Matcher matcher;

                if (lowerCase.matcher(password).find()) {
                    if (upperCase.matcher(password).find()) {
                        if (digit.matcher(password).find()) {
                            return true;
                        } else {
                            mEditTextPassword.setError("The password should contain 0-9.");
                        }
                    } else {
                        mEditTextPassword.setError("The password should contain A-Z.");
                    }
                } else {
                    mEditTextPassword.setError("The password should contain a-z.");
                }

            } else if (password.isEmpty()) {
                mEditTextPassword.setError(getResources().getString(R.string.error_empty_field));
            } else {
                mEditTextPassword.setError(getResources().getString(R.string.error_password_too_short));
            }
        }
        return false;
    }

    private boolean isEmailValid() {
        if (mEditTextEmail != null) {
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
                mEditTextEmail.setError(getResources().getString(R.string.error_empty_field));
                return false;
            }
        } else {
            Toast.makeText(LoginActivity.this, "EditTextEmail was not initialised.", Toast.LENGTH_LONG);
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this, R.style.AlertDialogStyle);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finish();
                }
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setTitle("Do you really want to Exit?");

        Dialog exitDialog = alertDialog.create();
        exitDialog.show();
    }

    public void openWebisteOnClick(View view) {
        Intent openWebsite = new Intent(Intent.ACTION_VIEW);
        openWebsite.setData(Uri.parse(getResources().getText(R.string.moto_website).toString()));
        startActivity(openWebsite);
    }

    public void openTermsAndConditionsOnClick(View view) {
        Intent openTerms = new Intent(this, TermsAndConditionsActivity.class);
        startActivityForResult(openTerms, INTENT_REQUEST_TERMS_AND_CONDITIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case INTENT_REQUEST_TERMS_AND_CONDITIONS: {

                }
                break;
            }
        }

    }

    private boolean dataBaseCheck() {
        return true;
    }

    public void loginOnClick(View view) {
        if (dataBaseCheck() &&
                isEmailAccepted() &&
                isPasswordAccepted()) {
            Toast.makeText(this, "OK !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, getResources().getText(R.string.error_invalid_user), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void loginWithGoogleOnClick(View view) {
        if (dataBaseCheck()) {
            // TODO: get google user from database
        } else {
            // TODO: register google user to database
        }
    }

    private void openMainActivity() {
        Intent openMainMenu = new Intent(LoginActivity.this, )
    }
}
