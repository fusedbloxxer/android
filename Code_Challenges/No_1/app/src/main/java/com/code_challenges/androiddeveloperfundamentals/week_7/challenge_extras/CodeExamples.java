package com.code_challenges.androiddeveloperfundamentals.week_7.challenge_extras;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.R;

public class CodeExamples extends AppCompatActivity {
    private LinearLayout mLinearLayoutParent;
    private ImageView mImageViewAnimation;
    private boolean mShapeAndStrokeAnimation;
    private AnimationDrawable mShapeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_examples);

        initView();
    }

    private void initView() {
        mLinearLayoutParent = findViewById(R.id.linear_layout_background);
        mImageViewAnimation = findViewById(R.id.image_view_shape_and_stroke_animation);

        mShapeAndStrokeAnimation = false;

        AnimationDrawable animationDrawable = (AnimationDrawable) mLinearLayoutParent.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        mShapeAnimation = (AnimationDrawable) mImageViewAnimation.getBackground();
        mShapeAnimation.setExitFadeDuration(1000);
        mShapeAnimation.setEnterFadeDuration(2000);


    }

    public void openMapsOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0"));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openDatePickerOnClick(View view) {
        DialogFragment dialog = new CustomDatePickerDialog();
        dialog.show(getSupportFragmentManager(), "Date Picker");
    }

    public void openTimePickerOnClick(View view) {
        DialogFragment dialog = new CustomTimePickerDialog();
        dialog.show(getSupportFragmentManager(), "Time Picker");
    }

    public void openAlertDialogOnClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notice");
        builder.setMessage("Alert Title");

        builder.setPositiveButton("Open", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CodeExamples.this, getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CodeExamples.this, "Cancelling", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Remind me", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CodeExamples.this, "Postpone", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void showAnimationOnClick(View view) {
        if (mShapeAndStrokeAnimation) {
            mImageViewAnimation.setVisibility(View.GONE);
            mShapeAnimation.stop();
            mShapeAndStrokeAnimation = false;
        } else {
            mImageViewAnimation.setVisibility(View.VISIBLE);
            mShapeAnimation.start();
            mShapeAndStrokeAnimation = true;

            Snackbar snackbar = Snackbar
                    .make(view, "FAB disappeared :O", Snackbar.LENGTH_LONG)
                    .setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mImageViewAnimation.setVisibility(View.GONE);
                            mShapeAnimation.stop();
                            mShapeAndStrokeAnimation = false;
                        }
                    });
            
            // CUM ARATA UNDO
            snackbar.setActionTextColor(getResources().getColor(R.color.orange));
            View snackbarView = snackbar.getView();

            // CULOAREA DE FUNDAL
            snackbarView.setBackgroundColor(ContextCompat.getColor(CodeExamples.this, R.color.colorPrimary));

            // CUM ARATA HELP
            TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(CodeExamples.this, R.color.white));

            // NU UITA DE SHOW
            snackbar.show();
        }
    }
}