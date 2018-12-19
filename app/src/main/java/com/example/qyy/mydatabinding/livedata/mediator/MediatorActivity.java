package com.example.qyy.mydatabinding.livedata.mediator;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.print.PrinterId;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class MediatorActivity extends AppCompatActivity implements View.OnClickListener {
    private MutableLiveData<String> a = new MutableLiveData<>();
    private MutableLiveData<String> b = new MutableLiveData<>();
    private TextView mtva;
    private TextView mtvb;
    private TextView mtvall;
    private MediatorLiveData<Boolean> all = new MediatorLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediator);
        mtva = (TextView) findViewById(R.id.tv_a);
        mtvb = (TextView) findViewById(R.id.tv_b);
        mtvall = (TextView) findViewById(R.id.vt_all);
        a.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtva.setText(s);
            }
        });

        b.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtvb.setText(s);
            }
        });

        all.addSource(a, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                all.setValue(true);
            }
        });
        all.addSource(b, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                all.setValue(false);
            }
        });
        all.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                mtvall.setText("" + aBoolean);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_a:
                a.setValue("我是A");
                break;
            case R.id.btn_b:
                b.setValue("我是B");
                break;
            default:
                break;

        }
    }
}
