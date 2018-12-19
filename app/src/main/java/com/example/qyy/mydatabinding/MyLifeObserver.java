package com.example.qyy.mydatabinding;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyLifeObserver implements LifecycleObserver {
    private int ii;
    public MyLifeObserver(int i) {
        ii=i;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getoNCreate() {
        Log.v("onlifecycle", "getoNCreate"+ii);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void getoNStart() {
        Log.v("onlifecycle", "getoNStart"+ii);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void getoNResume() {
        Log.v("onlifecycle", "getoNResume"+ii);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void getoNPause() {
        Log.v("onlifecycle", "getoNPause"+ii);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void getoNStop() {
        Log.v("onlifecycle", "getoNStop"+ii);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void getoNDestroy() {
        Log.v("onlifecycle", "getoNDestroy"+ii);
    }

}
