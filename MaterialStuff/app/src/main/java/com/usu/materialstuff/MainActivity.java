package com.usu.materialstuff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, HomeFragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toolbar.setNavigationOnClickListener(view -> {
            drawer.open();
        });

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            if (menuItem.getItemId() == R.id.home_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            if (menuItem.getItemId() == R.id.profile_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            if (menuItem.getItemId() == R.id.settings_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            drawer.close();
            return true;
        });
    }
}