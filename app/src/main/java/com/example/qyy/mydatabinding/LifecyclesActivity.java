package com.example.qyy.mydatabinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LifecyclesActivity extends AppCompatActivity {
//    private MyLifeObserver myLifeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
//        myLifeObserver = new MyLifeObserver();
//        getLifecycle().addObserver(myLifeObserver);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fraFragment.newInstance())
                    .commitNow();
        }
    }
}
