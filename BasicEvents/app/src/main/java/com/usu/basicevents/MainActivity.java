package com.usu.basicevents;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The old imperative way
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        AppCompatTextView textView = new AppCompatTextView(this);
//        textView.setText("Hello, this is my first view!");
//        textView.setTextSize(18);
//
//        linearLayout.addView(textView);
//
//        AppCompatButton button = new AppCompatButton(this);
//        button.setText("Press Me!");
//
//        linearLayout.addView(button);
        setContentView(R.layout.activity_main);

        AppCompatButton plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener((view) -> {
            count += 1;
            AppCompatTextView numberText = findViewById(R.id.number_text);
            numberText.setText("" + count);
        });

        AppCompatButton minusButton = findViewById(R.id.minus_button);
        minusButton.setOnClickListener((view) -> {
            count -= 1;
            AppCompatTextView numberText = findViewById(R.id.number_text);
            numberText.setText("" + count);
        });

//        myButton.setOnClickListener((view) -> {
//            AppCompatTextView messageTextView = findViewById(R.id.message);
//            messageTextView.setText("Welcome to our app");
//
//        });

    }
}