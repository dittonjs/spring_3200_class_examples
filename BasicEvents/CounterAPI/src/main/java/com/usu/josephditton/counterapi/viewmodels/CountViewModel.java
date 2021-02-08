package com.usu.josephditton.counterapi.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CountViewModel extends ViewModel {
    private MutableLiveData<Long> count;
    private DatabaseReference db;

    public CountViewModel() {
        db = FirebaseDatabase.getInstance().getReference();
    }

    public MutableLiveData<Long> getCount() {
        if (count == null) {
            count = new MutableLiveData<>();
            count.setValue((long)0);
            initializeCount();
        }
        return count;
    }

    public void incrementCount() {
       db.child("count").setValue(count.getValue() + 1);
    };

    public void decrementCount() {
        db.child("count").setValue(count.getValue() - 1);
    };

    private void initializeCount() {
        db.child("count").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                count.setValue((long) snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
