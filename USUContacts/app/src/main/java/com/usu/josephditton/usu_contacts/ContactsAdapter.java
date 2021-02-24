package com.usu.josephditton.usu_contacts;

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

import com.usu.josephditton.contactsapi.models.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    protected ObservableArrayList<Contact> contacts;
    static int holderCount = 0;
    static int callCount = 0;
    public ContactsAdapter(ObservableArrayList<Contact> contacts) {

        this.contacts = contacts;
        this.contacts.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Contact>>() {
            @Override
            public void onChanged(ObservableList<Contact> sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Contact> sender, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<Contact> sender, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<Contact> sender, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Contact> sender, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        holderCount ++;
        Log.d("asdf", "" + holderCount);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        TextView nameDisplay = holder.getItemView().findViewById(R.id.nameDisplay);
        TextView phoneNumberDisplay = holder.getItemView().findViewById(R.id.phoneNumberDisplay);
        nameDisplay.setText(contact.name);
        phoneNumberDisplay.setText(contact.phoneNumber);
        Button button = holder.getItemView().findViewById(R.id.call);
        button.setOnClickListener((view) -> {
            Log.d("I GO CALLED", "" + ++callCount);
        });
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public View getItemView() {
            return itemView;
        }
    }
}
