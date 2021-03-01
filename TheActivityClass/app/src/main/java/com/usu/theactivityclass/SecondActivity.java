package com.usu.theactivityclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("usersName");
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello, " + name + ", welcome to the second activity");
    }
}
