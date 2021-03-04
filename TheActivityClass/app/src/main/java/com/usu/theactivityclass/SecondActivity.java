package com.usu.theactivityclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EditText noteEditText = findViewById(R.id.note);
        findViewById(R.id.save).setOnClickListener((view) -> {
            String note = noteEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("note", note);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}
