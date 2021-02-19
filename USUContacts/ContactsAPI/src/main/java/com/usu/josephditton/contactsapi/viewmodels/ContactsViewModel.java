package com.usu.josephditton.contactsapi.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usu.josephditton.contactsapi.models.Contact;

import java.util.ArrayList;
import java.util.Random;

public class ContactsViewModel extends ViewModel {
    // old way
//    private MutableLiveData<ArrayList<Contact>> contacts;
    private ObservableArrayList<Contact> contacts;
    private DatabaseReference db;
    public ContactsViewModel() {
        db = FirebaseDatabase.getInstance().getReference();
    }

    public ObservableArrayList<Contact> getContacts() {
        if (contacts == null) {
            contacts = new ObservableArrayList<Contact>();
            loadContacts();
        }
        return contacts;
    }

    private void loadContacts() {

        // OLD WAY
//        db.child("/contacts").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                ArrayList<Contact> newContacts = new ArrayList<>();
//                for (DataSnapshot ss : snapshot.getChildren()) {
//                    Contact contact = ss.getValue(Contact.class);
//                    contact.id = ss.getKey();
//                    newContacts.add(contact);
//                }
//                contacts.setValue(newContacts);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        db.child("/contacts").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                contacts.add(snapshot.getValue(Contact.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("CHANGED", "A contact was changed");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Log.d("REMOVED", "A contact was removed");
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void saveContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        db.child("/contacts").push().setValue(newContact);
    }

    public void updateContactName(String id, String name) {
        db.child("/contacts").child(id).child("name").setValue(name);
    }




}
