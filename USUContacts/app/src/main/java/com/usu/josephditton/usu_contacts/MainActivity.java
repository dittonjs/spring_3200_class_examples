package com.usu.josephditton.usu_contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.usu.josephditton.contactsapi.viewmodels.ContactsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactsViewModel viewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
        viewModel.getContacts().observe(this, (contacts) -> {
            // display the contacts
            System.out.println("I got some contacts " + contacts.size());
        });
    }
}