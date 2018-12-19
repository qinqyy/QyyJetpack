package com.example.qyy.mydatabinding;

import android.databinding.BaseObservable;
import android.util.Log;

import com.example.qyy.mydatabinding.bean.User;

import java.util.List;

public class RecyViewModel extends BaseObservable {
    private List<User> mlist;

    public RecyViewModel(List<User> mlist) {
        this.mlist = mlist;
        Log.v("jkjkjk", "one" + mlist.size());
    }

    public List<User> getMlist() {
        Log.v("jkjkjk", "two" + mlist.size());
        return mlist;
    }
}
