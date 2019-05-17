package com.androidapp.fusedbloxxer.networkingapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRetrofitActivity(View view) {
        Intent retrofitActivity = new Intent(MainMenuActivity.this, RobloxActivity.class);
        startActivity(retrofitActivity);
    }
}
