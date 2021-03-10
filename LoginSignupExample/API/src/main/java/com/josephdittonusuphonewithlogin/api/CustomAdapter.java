package com.josephdittonusuphonewithlogin.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

public abstract class CustomAdapter<T> extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    protected ObservableArrayList<T> data;

    public CustomAdapter(ObservableArrayList<T> data) {

        this.data = data;
        this.data.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<T>>() {
            @Override
            public void onChanged(ObservableList<T> sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<T> sender, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<T> sender, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<T> sender, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<T> sender, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);

        return new ViewHolder(view);
    }

    protected abstract int getLayout();

    @Override
    public abstract void onBindViewHolder(@NonNull ViewHolder holder, int position);


    @Override
    public int getItemCount() {
        return data.size();
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

// AN EXAMPLE OF HOW TO USE!
//public class ContactsAdapter extends CustomAdapter<Contact> {
//    ContactClickedListener listener;
//    public ContactsAdapter(ObservableArrayList<Contact> data, ContactClickedListener listener) {
//        super(data);
//        this.listener = listener;
//    }
//
//    @Override
//    public int getLayout() {
//        return R.layout.contact_list_item;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Contact contact = data.get(position);
//        TextView nameDisplay = holder.getItemView().findViewById(R.id.nameDisplay);
//        TextView phoneNumberDisplay = holder.getItemView().findViewById(R.id.phoneNumberDisplay);
//        nameDisplay.setText(contact.name);
////        phoneNumberDisplay.setText(contact.phoneNumber);
//        Button button = holder.getItemView().findViewById(R.id.call);
//        button.setOnClickListener(view -> {
//            listener.onClick(contact);
//        });
//    }
//}

