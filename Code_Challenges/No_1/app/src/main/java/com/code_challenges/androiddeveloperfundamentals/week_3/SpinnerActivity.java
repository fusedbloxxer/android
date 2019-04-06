package com.code_challenges.androiddeveloperfundamentals.week_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner mSpinnerSweets;
    private List<String> mSweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initView();
        getSourceData();
        setAdapter();

    }

    private void initView() {
        mSpinnerSweets = findViewById(R.id.spinner_sweets);

        mSpinnerSweets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, "Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getSourceData() {
        mSweets = new ArrayList<>();
        mSweets.add("Cupcake");
        mSweets.add("Donut");
        mSweets.add("Eclair");
        mSweets.add("KitKat");
        mSweets.add("Pie");
    }

    private void setAdapter() {
        mSpinnerSweets.setAdapter(new ArrayAdapter<String>(SpinnerActivity.this,
                android.R.layout.simple_list_item_1,
                mSweets));
    }
}
