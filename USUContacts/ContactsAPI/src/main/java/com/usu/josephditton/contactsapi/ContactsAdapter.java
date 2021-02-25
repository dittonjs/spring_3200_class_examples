package com.usu.josephditton.contactsapi;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.josephditton.contactsapi.CustomAdapter;
import com.usu.josephditton.contactsapi.models.Contact;

public class ContactsAdapter extends CustomAdapter<Contact> {
    ContactClickedListener listener;
    public ContactsAdapter(ObservableArrayList<Contact> data, ContactClickedListener listener) {
        super(data);
        this.listener = listener;
    }

    @Override
    public int getLayout() {
        return R.layout.contact_list_item;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = data.get(position);
        TextView nameDisplay = holder.getItemView().findViewById(R.id.nameDisplay);
        TextView phoneNumberDisplay = holder.getItemView().findViewById(R.id.phoneNumberDisplay);
        nameDisplay.setText(contact.name);
//        phoneNumberDisplay.setText(contact.phoneNumber);
        Button button = holder.getItemView().findViewById(R.id.call);
        button.setOnClickListener(view -> {
            listener.onClick(contact);
        });
    }
}
