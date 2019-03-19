package com.example.fundevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    public void btnHelloOnClick(View view) {
        if (mEditTextEmail != null) {
            String email = mEditTextEmail.getText().toString();
            if (email != null && !email.isEmpty()) {
                mTextViewHello.setText(email);
            } else {
                mEditTextEmail.setError(getString(R.string.error_email_missing));
            }
        } else {
            Toast.makeText(MainActivity.this, "Please make EditText not null :D", Toast.LENGTH_LONG).show();
        }
    }
}
