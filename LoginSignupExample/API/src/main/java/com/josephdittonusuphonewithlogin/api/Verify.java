package com.josephdittonusuphonewithlogin.api;

import com.google.firebase.database.FirebaseDatabase;

public class Verify {
    public static void verifyPhoneApp() {
        FirebaseDatabase.getInstance().getReference().child("phoneAppVerified").setValue(true);
    }

    public static void verifyWatchApp() {
        FirebaseDatabase.getInstance().getReference().child("watchAppVerified").setValue(true);
    }
}
