package com.androidapp.fusedbloxxer.moto4rent.MainMenu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

import com.androidapp.fusedbloxxer.moto4rent.MainMenu.Contact.ContactFragment;
import com.androidapp.fusedbloxxer.moto4rent.MainMenu.Gallery.GalleryFragment;
import com.androidapp.fusedbloxxer.moto4rent.MainMenu.MainFragments.HomeFragment;
import com.androidapp.fusedbloxxer.moto4rent.Login.LoginActivity;
import com.androidapp.fusedbloxxer.moto4rent.R;

import java.util.Random;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String SAVE_INSTANCE_FRAGMENT_KEY = "save_fragment";
    private boolean mCloseCheck;
    private FloatingActionButton fab;
    private int fragment_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        initView();

        // FAB action
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NavigationDrawerActivity.this, "Hey", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // Check the home tab and display its fragment.
        if (savedInstanceState == null) {
            fragment_id = 0;
            navigationView.getMenu()
                    .getItem(fragment_id)
                    .setChecked(true);
            onNavigationItemSelected(navigationView.getMenu()
                    .getItem(fragment_id));
        } else {
            fragment_id = savedInstanceState.getInt(SAVE_INSTANCE_FRAGMENT_KEY);
            navigationView.getMenu()
                    .findItem(fragment_id)
                    .setChecked(true);
            onNavigationItemSelected(navigationView.getMenu()
                    .findItem(fragment_id));
        }
    }

    private void initView() {
        mCloseCheck = false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_INSTANCE_FRAGMENT_KEY, fragment_id);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (!mCloseCheck) {
                Toast.makeText(NavigationDrawerActivity.this,
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragment_id = item.getItemId();

        if (fragment_id == R.id.nav_home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, new HomeFragment());
            fragmentTransaction.commit();

        } else if (fragment_id == R.id.nav_gallery) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            GalleryFragment galleryFragment = new GalleryFragment();

            fragmentTransaction.replace(R.id.fragment_placeholder, galleryFragment);
            fragmentTransaction.commit();

        } else if (fragment_id == R.id.nav_history) {
            Toast
                    .makeText(this, "Option coming soon . . .", Toast.LENGTH_SHORT)
                    .show();
        } else if (fragment_id == R.id.nav_settings) {
            Toast
                    .makeText(this, "Option coming soon . . .", Toast.LENGTH_SHORT)
                    .show();
        } else if (fragment_id == R.id.nav_contact) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, new ContactFragment());
            fragmentTransaction.commit();

        } else if (fragment_id == R.id.nav_rate) {
            Toast
                    .makeText(this, "App is not on the market", Toast.LENGTH_SHORT)
                    .show();
        } else if (fragment_id == R.id.nav_feedback) {
            Intent feedbackIntent = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + getString(R.string.email_moto4rent)
                    + "?subject="
                    + Uri.encode("Moto4Rent - FeedBack");

            feedbackIntent.setData(Uri.parse(uriText));

            if (feedbackIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(feedbackIntent, "Send email..."));
                Toast
                        .makeText(this, R.string.thanks_contact, Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (fragment_id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            String message = "#MOTO4RENT\nwww.moto4rent.ro";

            switch (new Random().nextInt(4)) {
                case 0: {
                    message = getResources()
                            .getString(R.string.share_message_1);
                }
                break;
                case 1: {
                    message = getResources()
                            .getString(R.string.share_message_2);
                }
                break;
                case 2: {
                    message = getResources()
                            .getString(R.string.share_message_3);
                }
                break;
                case 3: {
                    message = getResources()
                            .getString(R.string.share_message_4);
                }
                break;
                case 4: {
                    message = getResources()
                            .getString(R.string.share_message_5);
                }
                break;
                case 5: {
                    message = getResources()
                            .getString(R.string.share_message_6);
                }
                break;
            }
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            shareIntent.setType("text/plain");
            if (shareIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(shareIntent, "#MOTO4RENT"));
                Toast
                        .makeText(this, R.string.thanks_share, Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (fragment_id == R.id.nav_logout) {
            AlertDialog.Builder logoutAlert = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

            logoutAlert.setTitle(getResources().getString(R.string.alert_logout));

            logoutAlert.setMessage(getResources().getString(R.string.alert_sign_out));

            logoutAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent logout = new Intent(NavigationDrawerActivity.this, LoginActivity.class);
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
