package com.example.qyy.mydatabinding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> m = new MutableLiveData<>();

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    public MutableLiveData<String> getM() {
        return m;
    }

    public void setStr(String str) {
        m.setValue(str);
    }
}
