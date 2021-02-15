package com.usu.josephditton.contactsapi.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usu.josephditton.contactsapi.models.Contact;

import java.util.ArrayList;

public class ContactsViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Contact>> contacts;
    private DatabaseReference db;
    public ContactsViewModel() {
        db = FirebaseDatabase.getInstance().getReference();
    }

    public MutableLiveData<ArrayList<Contact>> getContacts() {
        if (contacts == null) {
            contacts = new MutableLiveData<>();
            contacts.setValue(new ArrayList<>());
            loadContacts();
        }
        return contacts;
    }

    private void loadContacts() {
        db.child("/contacts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ss : snapshot.getChildren()) {
                    contacts.getValue().add(ss.getValue(Contact.class));
                }
                contacts.setValue(contacts.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void saveContact(String name, String phoneNumber) {
        Contact newContact = new Contact();
    }




}
