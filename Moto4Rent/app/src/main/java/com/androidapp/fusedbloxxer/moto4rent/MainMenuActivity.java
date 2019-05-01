package com.androidapp.fusedbloxxer.moto4rent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomNavigationView;
    private CoordinatorLayout mCoordinatorLayout;
    private PageAdapter mPageAdapter;
    private ViewPager mViewPager;
    private boolean mCloseCheck;
    private MenuItem mPreviousMenuItem;
    private int mBottomTabCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        initView();
        setViewPagerAdapter();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "Hey", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void setViewPagerAdapter() {
        mPageAdapter = new PageAdapter(getSupportFragmentManager());

        mPageAdapter.addFragment(new TripFragment());
        mPageAdapter.addFragment(new ShowCaseFragment());
        mPageAdapter.addFragment(new RentFragment());
        mViewPager.setAdapter(mPageAdapter);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.nav_bot_trip) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(0);
                    return true;
                } else if (id == R.id.nav_bot_showcase) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(1);
                    return true;
                } else if (id == R.id.nav_bot_rent) {
                    mPreviousMenuItem = menuItem;
                    mViewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mPreviousMenuItem != null) {
                    mPreviousMenuItem.setChecked(false);
                    mPreviousMenuItem = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuItem.setChecked(true);
                } else {
                    mPreviousMenuItem = mBottomNavigationView.getMenu().getItem(position);
                    mPreviousMenuItem.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mBottomNavigationView.setSelectedItemId(R.id.nav_bot_showcase);
    }

    private void initView() {
        mCoordinatorLayout = findViewById(R.id.coordinator_layout);
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mViewPager = findViewById(R.id.view_pager);
        mBottomTabCount = 3;
        mCloseCheck = false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (mCloseCheck == false) {
                Toast.makeText(MainMenuActivity.this,
                        getResources().getText(R.string.message_exit), Toast.LENGTH_SHORT)
                        .show();
                mCloseCheck = true;
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_version) {

        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder logoutAlert = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

            logoutAlert.setTitle(getResources().getString(R.string.alert_logout));

            logoutAlert.setMessage(getResources().getString(R.string.alert_sign_out));

            logoutAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent logout = new Intent(MainMenuActivity.this, LoginActivity.class);
                    startActivity(logout);
                    finish();
                }
            });

            logoutAlert.setNegativeButton("NO", null);

            Dialog logoutDialog = logoutAlert.create();
            logoutDialog.show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}