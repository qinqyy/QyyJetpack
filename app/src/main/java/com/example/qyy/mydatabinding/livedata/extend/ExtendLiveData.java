package com.example.qyy.mydatabinding.livedata.extend;

import android.arch.lifecycle.LiveData;
import android.util.Log;

public class ExtendLiveData extends LiveData<String> {
    private static ExtendLiveData extendLiveData;

    public void set(String str) {
        setValue(str);
    }

    public static ExtendLiveData getex() {
        if (extendLiveData == null) {
            extendLiveData = new ExtendLiveData();
        }
        return extendLiveData;
    }

    private ExtendLiveData() {

    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.v("ononono","onActive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.v("ononono","onInactive");
    }
}
