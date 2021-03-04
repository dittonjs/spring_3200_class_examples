package com.usu.theactivityclass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_NOTE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ON CREATE", "was called");
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.newNote);


        myButton.setOnClickListener((view) -> {
            // go to a new activity
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, NEW_NOTE);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ON RESUME", "was called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_NOTE && resultCode == Activity.RESULT_OK) {
            TextView textView = new TextView(this);
            textView.setText(data.getStringExtra("note"));
            setContentView(textView);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}