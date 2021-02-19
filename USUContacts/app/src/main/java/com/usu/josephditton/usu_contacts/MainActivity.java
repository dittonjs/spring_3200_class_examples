package com.usu.josephditton.usu_contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableList;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.usu.josephditton.contactsapi.models.Contact;
import com.usu.josephditton.contactsapi.viewmodels.ContactsViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout contactsList = findViewById(R.id.contactsList);
        ContactsViewModel viewModel = new ViewModelProvider(this).get(ContactsViewModel.class);
        viewModel.getContacts().addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {

            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                Contact contact = viewModel.getContacts().get(positionStart);
                View contactListItem = LayoutInflater.from(MainActivity.this).inflate(R.layout.contact_list_item, null);
                TextView nameDisplay = contactListItem.findViewById(R.id.nameDisplay);
                TextView phoneNumberDisplay = contactListItem.findViewById(R.id.phoneNumberDisplay);
                Button callButton = contactListItem.findViewById(R.id.call);
                callButton.setOnClickListener((view) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + contact.phoneNumber));
                    startActivity(intent);
                });

                nameDisplay.setText(contact.name);
                phoneNumberDisplay.setText(contact.phoneNumber);
                contactsList.addView(contactListItem);
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {

            }
        });

        findViewById(R.id.save).setOnClickListener((view) -> {
           EditText nameEditText = findViewById(R.id.name);
           EditText numberEditText = findViewById(R.id.number);
            Log.d("NAME", nameEditText.getText().toString());
            Log.d("NUM", numberEditText.getText().toString());
            viewModel.saveContact(nameEditText.getText().toString(), numberEditText.getText().toString());
        });
    }
}