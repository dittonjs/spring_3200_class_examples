package com.usu.basicevents.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private MutableLiveData<Integer> count = new MutableLiveData<Integer>();


    public MutableLiveData<Integer> getCount() {
        if (count == null) {
            count.setValue(0);
        }
        return count;
    }

    public void incrementCount() {
        count.setValue(count.getValue() + 1);

    };

    public void decrementCount() {
        count.setValue(count.getValue() - 1);
    };
}
