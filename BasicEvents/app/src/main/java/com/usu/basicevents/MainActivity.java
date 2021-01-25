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

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

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

        AppCompatButton myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener((view) -> {
            Log.d("BUTTON", "My button was pressed");
        });
    }
}