package com.example.fundevelopment.week_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.fundevelopment.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private List<String> mColors;
    private Spinner mSpinnerColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initView();
        setColors();
        setAdapter();

    }

    // get Spinner
    private void initView() {
        mSpinnerColors = findViewById(R.id.spinner_colors);
    }

    /// Adapter
    private void setAdapter() {
        mSpinnerColors.setAdapter(new ArrayAdapter<>(SpinnerActivity.this,  // Adaptor default context
                android.R.layout.simple_list_item_1, // Layout scris deja in android
                mColors)); // Data source
    }

    /// Data Source
    private void setColors() {
        mColors = new ArrayList<>();
        mColors.add("Verde");
        mColors.add("Albastru");
        mColors.add("Siclam");
        mColors.add("Magenta");
        mColors.add("Roz");
        mColors.add("Galben");
    }
}
