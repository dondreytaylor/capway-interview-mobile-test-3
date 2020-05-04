package com.news.newsfeed.ui.BaseClass;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.news.newsfeed.R;

import org.json.JSONException;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity
{
    private AppBarConfiguration mAppBarConfiguration;

    protected final void onCreate(Bundle savedInstanceState, int layoutId,boolean showMenu)
    {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        setUpToolbar(showMenu);
        if (showMenu)
        {
            setUpnavigationDrawer();
        }

    }

    private void setUpToolbar(boolean showMenu)
    {
        // set Toolbar with drawer menu icon
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        if (showMenu)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }


    private void setUpnavigationDrawer()
    {
        // set navigation drawer items
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
