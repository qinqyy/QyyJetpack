package com.example.qyy.mydatabinding.livedata.transformation;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class SwitchMapActivity extends AppCompatActivity implements View.OnClickListener {
    private MutableLiveData<String> m = new MutableLiveData<>();
    private MutableLiveData<Boolean> b = new MutableLiveData<>();
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_map);
        mtv = (TextView) findViewById(R.id.tv_switch);
        LiveData<String> q = Transformations.switchMap(b, new Function<Boolean, LiveData<String>>() {
            @Override
            public LiveData<String> apply(Boolean input) {
                return m;
            }
        });

        q.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtv.setText(s);
            }
        });


    }

    @Override
    public void onClick(View v) {
        m.setValue("我是发二个");
        b.setValue(true);
    }
}
