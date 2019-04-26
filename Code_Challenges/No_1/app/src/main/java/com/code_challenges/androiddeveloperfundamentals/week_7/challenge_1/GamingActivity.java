package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.code_challenges.androiddeveloperfundamentals.R;

public class GamingActivity extends AppCompatActivity {
    private static final String URL = "http://blog.dota2.com/?l=english";
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        initView();
    }

    private void initView() {
        mWebView = findViewById(R.id.web_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(URL);
    }

    public void openWebsiteOnClick(View view) {
        Intent openWebsite = new Intent(Intent.ACTION_VIEW);

        openWebsite.setData(Uri.parse("https://www.dota2.com"));

        if (getIntent().resolveActivity(getPackageManager()) != null) {
            startActivity(openWebsite);
        }
    }
}
