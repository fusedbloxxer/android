package com.code_challenges.androiddeveloperfundamentals.week_5.FourthCodeChallenge;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.net.URLEncoder;
import java.util.regex.Pattern;

public class MultiFunctionActivity extends AppCompatActivity {
    private EditText mEditTextViewCall, mEditTextViewShare;
    private EditText mEditTextViewWeb, mEditTextMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_function);

        initView();
    }

    private void initView() {
        mEditTextMap = findViewById(R.id.edit_text_location);
        mEditTextViewCall = findViewById(R.id.edit_text_phone_number);
        mEditTextViewShare = findViewById(R.id.edit_text_sharing_text);
        mEditTextViewWeb = findViewById(R.id.edit_text_website);
    }

    public void openCallActivityOnClick(View view) {
        if (checkEditText(mEditTextViewCall) && isPhoneValid(mEditTextViewCall)) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            if (intent.resolveActivity(getPackageManager()) != null) {
                intent.setData(Uri.parse("tel:" + mEditTextViewCall.getText().toString()));
                startActivity(intent);
            } else {
                Toast.makeText(this, "No app found to handle the action.", Toast.LENGTH_LONG);
            }
        }
    }

    public void openTextSharingActivityOnClick(View view) {
        if (checkEditText(mEditTextViewShare)) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            if (intent.resolveActivity(getPackageManager()) != null) {
                intent.putExtra(Intent.EXTRA_TEXT, mEditTextViewShare.getText().toString());
                intent.setType("text/plain");
                startActivity(intent);
            } else {
                Toast.makeText(this, "No app found to handle the action.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void openWebsiteOnClick(View view) {
        if (checkEditText(mEditTextViewWeb)) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (intent.resolveActivity(getPackageManager()) != null) {
                String query = mEditTextViewWeb.getText().toString();

                if (query.startsWith("http://") || query.startsWith("https://")) {
                    intent.setData(Uri.parse(query));
                } else {
                    intent.setData(Uri.parse("https://www.google.com/search?q=" + URLEncoder.encode(query)));
                }
                startActivity(intent);
            } else {
                Toast.makeText(this, "No app found to handle the action.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void openMapsOnClick(View view) {
        if (checkEditText(mEditTextMap)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + Uri.encode(mEditTextMap.getText().toString())));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No app found to handle the action." + Uri.encode(mEditTextMap.getText().toString()), Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean checkEditText(EditText editText) {
        String string = editText.getText().toString();

        if (string != null && !string.isEmpty()) {
            return true;
        } else {
            editText.setError("Empty field");
            return false;
        }
    }

    private boolean isPhoneValid(EditText editText) {
        if (editText.getText().toString().matches("\\d+")) {
            return true;
        } else {
            editText.setError("Invalid input received.");
            return false;
        }
    }
}