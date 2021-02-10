package com.usu.basicevents;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import com.usu.josephditton.counterapi.viewmodels.CountViewModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountViewModel countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        countViewModel.getCount().observe(this, (myCount) -> {
            AppCompatTextView numberText = findViewById(R.id.number_text);
            numberText.setText("" + myCount);
        });

        AppCompatButton plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener((view) -> {
            countViewModel.incrementCount();
        });

        AppCompatButton minusButton = findViewById(R.id.minus_button);
        minusButton.setOnClickListener((view) -> {
            countViewModel.decrementCount();
        });

    }
}