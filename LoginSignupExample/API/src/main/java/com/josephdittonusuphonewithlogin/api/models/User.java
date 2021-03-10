package com.josephdittonusuphonewithlogin.api.models;

import com.google.firebase.auth.FirebaseUser;

public class User {
    public String uid;
    public String email;
    public User(FirebaseUser user) {
        this.uid = user.getUid();
        this.email = user.getEmail();
    }
}

