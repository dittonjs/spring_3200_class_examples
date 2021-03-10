package com.josephdittonusuphonewithlogin.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.josephdittonusuphonewithlogin.api.viewmodels.UserViewModel;

public class HomeActivity extends ActivityWithUser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewModel.getUser().observe(this, (user) -> {
            if (user != null) {
                viewModel.storeUserSpecificData();
            }
        });

        findViewById(R.id.logout_button).setOnClickListener((view) -> {
            viewModel.signOut();
        });
    }


}