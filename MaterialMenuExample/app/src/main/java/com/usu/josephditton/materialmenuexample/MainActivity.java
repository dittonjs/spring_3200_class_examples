package com.usu.josephditton.materialmenuexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // an array of strings for the options
        String[] dropdownOptions = {"Option 1", "Option 2", "Option 3"};

        // an ArrayAdapter: this is sort of like the adapters we have used for recycler view only
        // it makes 2 assumptions:
        //  1.The root view of the layout file is a TextView
        //  2. The data passed in will an array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_menu_list_item, dropdownOptions);
        TextInputLayout input = findViewById(R.id.menu);
        ((AutoCompleteTextView) input.getEditText()).setAdapter(adapter);
    }
}