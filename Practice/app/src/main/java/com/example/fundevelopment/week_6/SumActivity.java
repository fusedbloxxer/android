package com.example.fundevelopment.week_6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fundevelopment.R;

public class SumActivity extends AppCompatActivity {
    public static final String FIRST_NUMBER = "first";
    public static final String SECOND_NUMBER = "second";

    private EditText mEditTextA, getmEditTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        initView();
    }

    private void initView() {
        mEditTextA = findViewById(R.id.edit_text_a);
        getmEditTextB = findViewById(R.id.edit_text_b);
    }

    public void sumOnClick(View view) {
        int firstNumber = 0;
        int secondNumber = 0;
        if (mEditTextA != null && mEditTextA.getText() != null) {
            firstNumber = Integer.parseInt(mEditTextA.getText().toString());
        }
        if (getmEditTextB != null && getmEditTextB.getText() != null) {
            secondNumber = Integer.parseInt(getmEditTextB.getText().toString());
        }
        Bundle sendParam = new Bundle();
        sendParam.putInt(FIRST_NUMBER, firstNumber);
        sendParam.putInt(SECOND_NUMBER, secondNumber);

        // Bundle
        //sendBundle(sendParam);

        // Method
        sendMethod(firstNumber, secondNumber);
    }

    private void sendBundle(Bundle sendParam) {
        SumFragment sumFragment = new SumFragment();
        sumFragment.setArguments(sendParam);
        replaceFragment(sumFragment);
    }
// TODO: Method
    private void sendMethod(int firstNumber, int secondNumber) {
        SumFragment sumFragment = new SumFragment();
        sumFragment.setmFirtNumber(firstNumber);
        sumFragment.setmSecondNumber(secondNumber);
        replaceFragment(sumFragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment_sum, fragment);
        fragmentTransaction.commit();
    }
}
