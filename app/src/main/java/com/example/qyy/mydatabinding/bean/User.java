package com.example.qyy.mydatabinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.EditText;

import com.example.qyy.mydatabinding.BR;

public class User extends BaseObservable {
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
        notifyPropertyChanged(BR.tip);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    private String name;
    private String tip;
    private int age;

}
