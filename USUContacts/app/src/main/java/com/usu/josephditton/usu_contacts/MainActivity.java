package com.usu.josephditton.usu_contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.usu.josephditton.contactsapi.ContactsAdapter;
import com.usu.josephditton.contactsapi.viewmodels.ContactsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView contactsList = findViewById(R.id.contactList);
        ContactsViewModel viewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
        ContactsAdapter adapter = new ContactsAdapter(
                viewModel.getContacts(),
                (contact) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + contact.phoneNumber));
                    startActivity(intent);
                }
            );

        contactsList.setAdapter(adapter);
        contactsList.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.save).setOnClickListener((view) -> {
           EditText nameEditText = findViewById(R.id.name);
           EditText numberEditText = findViewById(R.id.number);
            Log.d("NAME", nameEditText.getText().toString());
            Log.d("NUM", numberEditText.getText().toString());
            viewModel.saveContact(nameEditText.getText().toString(), numberEditText.getText().toString());
        });
    }
}