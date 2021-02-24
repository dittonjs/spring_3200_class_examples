package com.usu.josephditton.contactsapi.models;

import androidx.annotation.Nullable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Contact {
    public String name;
    public String phoneNumber;

    @Exclude
    public String id;

    public Contact() {}
//
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Contact) {
            Contact other = (Contact) obj;
            return other.id.equals(id);
        }
        return false;
    }
}
