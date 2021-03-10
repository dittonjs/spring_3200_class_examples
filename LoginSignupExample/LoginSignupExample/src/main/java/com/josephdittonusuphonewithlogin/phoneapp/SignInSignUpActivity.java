package com.josephdittonusuphonewithlogin.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.josephdittonusuphonewithlogin.api.viewmodels.UserViewModel;

public class SignInSignUpActivity extends AppCompatActivity {
    UserViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_in_sign_up);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button signIn = findViewById(R.id.signIn);
        Button signUp = findViewById(R.id.signUp);

        signIn.setOnClickListener((view) -> {
            viewModel.signIn(
                    email.getText().toString(),
                    password.getText().toString()
            );
        });

        signUp.setOnClickListener(view -> {
            viewModel.signUp(
                    email.getText().toString(),
                    password.getText().toString()
            );
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getUser().observe(this, (user) -> {
            if (user != null) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}