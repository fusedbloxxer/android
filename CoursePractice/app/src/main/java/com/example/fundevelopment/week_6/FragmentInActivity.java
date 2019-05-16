package com.example.fundevelopment.week_6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fundevelopment.R;

public class FragmentInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_in);

        addFragmentDynamically();
    }

    private void addFragmentDynamically() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new HelloFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(FragmentInActivity.this, "Back was pressed.",
                Toast.LENGTH_LONG).show();
        // La primul back din main activity te intreaba daca vrei sa iesi din aplicatie.
    }
}
