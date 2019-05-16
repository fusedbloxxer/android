package com.example.fundevelopment.week_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fundevelopment.R;

import java.util.List;

public class GithubActivity extends AppCompatActivity {
    private TextView mTextViewRetrofit;
    private UsersRepository mUsersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        initView();

        mUsersRepository = UsersRepository.getInstance();

        mUsersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                mTextViewRetrofit.setText("Github users =\n");
                for (User user: users) {
                    mTextViewRetrofit.append(user.toString() + " ///");
                }
                Logging.show("Github users = ", users.toString());
            }

            @Override
            public void onError() {
                mTextViewRetrofit.setText("error Github users = ");
                Logging.show("error Github users = ", "check the code :D ");
            }
        });
    }

    private void initView() {
        mTextViewRetrofit = findViewById(R.id.text_view_retrofit);
    }
}
