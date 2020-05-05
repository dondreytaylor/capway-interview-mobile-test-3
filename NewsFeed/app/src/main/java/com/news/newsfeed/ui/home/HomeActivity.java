package com.news.newsfeed.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.news.newsfeed.R;
import com.news.newsfeed.ui.BaseClass.BaseActivity;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class HomeActivity extends BaseActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ImageView notification;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.home_activity,true);
        registerViews();
    }

    private void registerViews()
    {
        notification = findViewById(R.id.toolbar_icon);
        notification.setImageResource(R.drawable.notification);
    }

}
