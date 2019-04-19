package com.code_challenges.androiddeveloperfundamentals.Bindings;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.code_challenges.androiddeveloperfundamentals.Bindings.Fragments.CourseDetailsFragment;
import com.code_challenges.androiddeveloperfundamentals.Bindings.RecyclerViewPackage.Course;
import com.code_challenges.androiddeveloperfundamentals.Bindings.RecyclerViewPackage.CourseAdapter;
import com.code_challenges.androiddeveloperfundamentals.R;
import com.code_challenges.androiddeveloperfundamentals.week_2.MainActivity;
import com.code_challenges.androiddeveloperfundamentals.week_3.FrameLayoutActivity;
import com.code_challenges.androiddeveloperfundamentals.week_3.LoginActivity;
import com.code_challenges.androiddeveloperfundamentals.week_3.ScrollViewActivity;
import com.code_challenges.androiddeveloperfundamentals.week_3.SpinnerActivity;
import com.code_challenges.androiddeveloperfundamentals.week_4.HolidayActivity;
import com.code_challenges.androiddeveloperfundamentals.week_4.RecycledViewStudents.RecyclerViewActivity;
import com.code_challenges.androiddeveloperfundamentals.week_5.FirstCodeChallenge.FirstActivityLifecycle;
import com.code_challenges.androiddeveloperfundamentals.week_5.FourthCodeChallenge.MultiFunctionActivity;
import com.code_challenges.androiddeveloperfundamentals.week_5.SecondCodeChallenge.TextPassageFirstActivity;
import com.code_challenges.androiddeveloperfundamentals.week_5.ThirdCodeChallenge.ChatFirstActivity;

import java.util.ArrayList;
import java.util.List;

public class PresentationActivity extends AppCompatActivity {
    public static final String COURSE_DETAILS_TITLE = "title";
    public static final String COURSE_DETAILS_DESCRIPTION = "description";
    public static final String COURSE_DETAILS_IMAGE= "image";

    private View.OnClickListener mRecyclerViewItemListener;
    private ConstraintLayout mConstraintLayout;
    private RecyclerView mRecyclerViewCourses;
    private ConstraintSet mConstraintSetMain;
    private FrameLayout mFrameLayoutDetails;
    private Fragment mFragmentCourseDetails;
    private ConstraintSet mConstraintSetAlt;
    private EditText mEditTextGoogleSearch;
    private CourseAdapter mCourseAdapter;
    private List<Course> mCourseList;
    private Integer mClickCounter;
    private Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        initView();
        getCourseData();
        setLayoutManager();
        setAdapter();
        addFragment();
    }

    private void addFragment() {
        mFragmentCourseDetails = new CourseDetailsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_course_details, mFragmentCourseDetails);
        fragmentTransaction.commit();
        flag = true;
    }

    @Override
    public void onBackPressed() {
        if (mFrameLayoutDetails.getVisibility() == View.VISIBLE && flag) {
            getSupportFragmentManager().beginTransaction().remove(mFragmentCourseDetails);
            flag = false;
            mFrameLayoutDetails.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    private void setAdapter() {
        mCourseAdapter = new CourseAdapter(mCourseList, mRecyclerViewItemListener);
        mRecyclerViewCourses.setAdapter(mCourseAdapter);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewCourses.setLayoutManager(layoutManager);
    }

    private void getCourseData() {
        if (mCourseList == null) {
            mCourseList = new ArrayList<>();

            mCourseList.add(new Course.Builder(R.drawable.android_1, 1)
                    .setCourseDescription("Introduction to Android :D")
                    .build());
            mCourseList.add(new Course.Builder(R.drawable.android_2, 2)
                    .setCourseDescription("Basic views and view groups.")
                    .setActivities(MainActivity.class)
                    .build());
            mCourseList.add(new Course.Builder(R.drawable.android_3, 3)
                    .setCourseDescription("FrameLayout, ScrollView and Spinner.")
                    .setActivities(FrameLayoutActivity.class,
                            LoginActivity.class,
                            ScrollViewActivity.class,
                            SpinnerActivity.class)
                    .build());
            mCourseList.add(new Course.Builder(R.drawable.android_4, 4)
                    .setCourseDescription("RecyclerView and ConstraintLayout.")
                    .setActivities(RecyclerViewActivity.class, HolidayActivity.class)
                    .build());
            mCourseList.add(new Course.Builder(R.drawable.android_5, 5)
                    .setCourseDescription("Activity lifecycle, implicit and explicit intents," +
                            " bundles.")
                    .setActivities(FirstActivityLifecycle.class,
                            TextPassageFirstActivity.class,
                            ChatFirstActivity.class,
                            MultiFunctionActivity.class)
                    .build());
        }
    }

    private void initView() {
        (mConstraintSetAlt = new ConstraintSet()).clone(this, R.layout.activity_presentation_2);
        mConstraintLayout = findViewById(R.id.constraint_layout_presentation);
        (mConstraintSetMain = new ConstraintSet()).clone(mConstraintLayout);
        mEditTextGoogleSearch = findViewById(R.id.edit_text_google);
        mRecyclerViewCourses = findViewById(R.id.recycler_view_course);
        mFrameLayoutDetails = findViewById(R.id.frame_layout_course_details);
        mClickCounter = 0;

        mEditTextGoogleSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 66) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    if (!mEditTextGoogleSearch.getText().toString().isEmpty())
                    intent.setData(Uri.parse("https://www.google.com/#q=" + mEditTextGoogleSearch.getText().toString()));
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });

        mRecyclerViewItemListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFrameLayoutDetails.setVisibility(View.VISIBLE);
                flag = true;

                Bundle bundle = new Bundle();
                int childPosition = mRecyclerViewCourses.getChildLayoutPosition(v);

                Course course = mCourseList.get(childPosition);
                bundle.putString(COURSE_DETAILS_TITLE, "Week Number " + course.getmCourseNumber());
                bundle.putString(COURSE_DETAILS_DESCRIPTION, course.getmCourseDescription());
                bundle.putInt(COURSE_DETAILS_IMAGE, course.getmImageResourceID());

                mFragmentCourseDetails.setArguments(bundle);
            }
        };
    }

    public void expandActivityOnClick(View view) {
        switch (mClickCounter) {
            case 0: {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(mConstraintLayout);
                }
                mConstraintSetAlt.applyTo(mConstraintLayout);
                mRecyclerViewCourses.setVisibility(View.VISIBLE);
                mClickCounter++;
            }
            break;
            case 1: {
                mEditTextGoogleSearch.setVisibility(View.VISIBLE);
                mClickCounter++;
            }
            break;
            case 2: {
                mEditTextGoogleSearch.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(mConstraintLayout);
                }
                mConstraintSetMain.applyTo(mConstraintLayout);
                mClickCounter = 0;
            }
            break;
        }
    }
}
