package com.androidapp.fusedbloxxer.moto4rent;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static final int INTENT_REQUEST_REGISTER_USER = 1;
    public static final int INTENT_REQUEST_FORGOT_PASS = 2;
    public static final String INTENT_REQUEST_EMAIL_ADDRESS = "email_address";
    public static final String RESTORE_EMAIL = "restore_email";
    public static final String RESTORE_PASS = "restore_password";
    private int mBackPresses;

    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mBackPresses = 0;
        mEditTextEmail = findViewById(R.id.edit_text_email_address);
        mEditTextPassword = findViewById(R.id.edit_text_password);
        mButtonLogin = findViewById(R.id.button_login);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RESTORE_EMAIL, mEditTextEmail.getText().toString());
        outState.putString(RESTORE_PASS, mEditTextPassword.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mEditTextEmail.setText(savedInstanceState.getString(RESTORE_EMAIL));
        mEditTextPassword.setText(savedInstanceState.getString(RESTORE_PASS));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case INTENT_REQUEST_REGISTER_USER: {
                if (resultCode == RESULT_OK) {
                    Toast
                            .makeText(this,
                                    getResources().getString(R.string.message_verify_email),
                                    Toast.LENGTH_LONG)
                            .show();
                }
            }
            break;
            case INTENT_REQUEST_FORGOT_PASS: {
                if (resultCode == RESULT_OK) {
                    Toast
                            .makeText(this,
                                    getResources().getString(R.string.message_verify_email),
                                    Toast.LENGTH_LONG)
                            .show();
                }
            }
            break;
        }
    }

    public void loginOnClick(View view) {
        if (LoginChecker
                .getInstance()
                .validLogin(this, mEditTextEmail, mEditTextPassword)) {
            openMainActivity(mEditTextEmail);
        }
    }

    public void loginWithGoogleOnClick(View view) {
        if (LoginChecker
                .getInstance()
                .dataBaseCheck()) {
            openMainActivity(mEditTextEmail);
        } else {
            // TODO: register google user to database
        }
    }

    private void openMainActivity(EditText mEditTextEmail) {
        Intent openMainMenu = new Intent(LoginActivity.this, MainMenuActivity.class);
        // TODO: Poate sa adaug mai multe informatii despre client ? Sa iau punctele sale, etc.
        if (mEditTextEmail != null) {
            openMainMenu.putExtra(INTENT_REQUEST_EMAIL_ADDRESS, mEditTextEmail.getText().toString());
        }
        startActivity(openMainMenu);
        this.finish();
    }

    public void registerOnClick(View view) {
        Intent startRegisterProcess = new Intent(this, RegisterUserActivity.class);
        startActivityForResult(startRegisterProcess, INTENT_REQUEST_REGISTER_USER);
    }

    public void recoverPasswordOnClick(View view) {
        Intent recoverPass = new Intent(this, ForgotPasswordActivity.class);
        startActivityForResult(recoverPass, INTENT_REQUEST_FORGOT_PASS);
    }

    public void skipOnClick(View view) {
        openMainActivity(null);
    }
}
