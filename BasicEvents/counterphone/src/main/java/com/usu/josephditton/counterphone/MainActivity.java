package com.usu.josephditton.counterphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.usu.josephditton.counterapi.viewmodels.CountViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountViewModel countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        TextView countTextView = findViewById(R.id.count);
        countViewModel.getCount().observe(this, (count) -> {
           countTextView.setText("" + count);
        });

        findViewById(R.id.increment).setOnClickListener((view) -> {
            countViewModel.incrementCount();
        });

        findViewById(R.id.decrement).setOnClickListener((view) -> {
            countViewModel.decrementCount();
        });

    }
}