package com.example.qyy.mydatabinding.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class LiveViewModel extends ViewModel {
    private MutableLiveData<String> mtvStr = new MutableLiveData<>();

    public MutableLiveData<String> getMtvStr() {
        return mtvStr;
    }


}
