package com.example.fundevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    /*
    private int mCount;
    private static String sNames;
    public static final String URL = "https://www.google.com";
    */

    // m - membru al clasei
    // s - static
    // caps lock - constant
    // camelCase in metoda

    private TextView mTextViewHello;
    private EditText mEditTextEmail;
    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTextViewHello = findViewById(R.id.text_view_hello);
        // Ia string-ul din fisier
        mTextViewHello.setText(getString(R.string.hello_from_java));
        mEditTextEmail = findViewById(R.id.edit_text_email);
        mRatingBar = findViewById(R.id.rating_bar);
    }

    public void btnHelloOnClick(View view) {
        if (mEditTextEmail != null) {
            String email = mEditTextEmail.getText().toString();
            if (email != null && !email.isEmpty()) {
                    mTextViewHello.setText(email);
                    mRatingBar.setVisibility(View.GONE);
            } else {
                mEditTextEmail.setError(getString(R.string.error_email_missing));
            }
        } else {
            Toast.makeText(MainActivity.this, "Please make EditText not null :D", Toast.LENGTH_LONG).show();
        }
    }
}
