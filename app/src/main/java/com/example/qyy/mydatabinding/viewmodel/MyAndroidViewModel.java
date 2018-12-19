package com.example.qyy.mydatabinding.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

public class MyAndroidViewModel extends AndroidViewModel {
    private MutableLiveData<String> name=new MutableLiveData<>();


    private Context context;


    public MutableLiveData<String> getName() {
        return name;
    }

    public MyAndroidViewModel(@NonNull Application application) {
        super(application);
        context = application;
        Log.v("xxxxxx", "MyAndroidViewModel" + context);
    }
}
