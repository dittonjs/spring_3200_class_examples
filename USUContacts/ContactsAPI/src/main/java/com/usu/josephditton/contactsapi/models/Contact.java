package com.usu.josephditton.contactsapi.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Contact {
    public String name;
    public String phoneNumber;

    public Contact() {}
//
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
