package com.androidapp.fusedbloxxer.moto4rent.Login;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginChecker {
    private static final LoginChecker ourInstance = new LoginChecker();

    static LoginChecker getInstance() {
        return ourInstance;
    }

    private LoginChecker() {
    }

    private boolean isPasswordValid(EditText mEditTextPassword) {
        if (mEditTextPassword != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailValid(EditText mEditTextEmail) {
        if (mEditTextEmail != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordAccepted(Context context, EditText mEditTextPassword) {
        if (isPasswordValid(mEditTextPassword)) {
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
                mEditTextPassword.setError(context.getResources().getString(R.string.error_empty_field));
            } else {
                mEditTextPassword.setError(context.getResources().getString(R.string.error_password_too_short));
            }
        } else {
            Toast
                    .makeText(context, "EditTextPassword was not initialised.", Toast.LENGTH_LONG)
                    .show();
        }
        return false;
    }

    boolean isEmailAccepted(Context context, EditText mEditTextEmail) {
        if (isEmailValid(mEditTextEmail)) {
            String email = mEditTextEmail.getText().toString();
            if (!email.isEmpty()) {
                Pattern pattern = Pattern.compile("^[0-9a-zA-Z.]+@[a-zA-Z]+\\.[a-zA-Z]+$");
                Matcher matcher = pattern.matcher(email);
                if (matcher.find()) {
                    return true;
                } else {
                    mEditTextEmail.setError("Invalid email address.");
                }
            } else {
                mEditTextEmail.setError(context.getResources().getString(R.string.error_empty_field));
            }
        } else {
            Toast
                    .makeText(context, "EditTextEmail was not initialised.", Toast.LENGTH_LONG)
                    .show();
        }
        return false;
    }

    boolean dataBaseCheck() {
        // TODO: DATABASE CHECK REGISTERED USER LOGIN + Sa tina minte ca te-ai logat
        return true;
    }

    boolean validLogin(Context context, EditText mEditTextEmail, EditText mEditTextPassword) {
        boolean emailCheck = LoginChecker
                .getInstance()
                .isEmailAccepted(context, mEditTextEmail);
        boolean passwordCheck = LoginChecker
                .getInstance()
                .isPasswordAccepted(context, mEditTextPassword);

        if (emailCheck && passwordCheck) {
            if (dataBaseCheck()) {
                return true;
            } else {
                Toast.makeText(context,
                        context.getResources().getText(R.string.error_invalid_user),
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
        return false;
    }
}
