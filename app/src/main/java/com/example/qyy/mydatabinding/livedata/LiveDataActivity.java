package com.example.qyy.mydatabinding.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mtvActivity;
    private LiveViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_one, LiveOneFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_two, LiveTwoFragment.newInstance()).commit();
        mtvActivity = (TextView) findViewById(R.id.tv_activity);
        model = ViewModelProviders.of(this).get(LiveViewModel.class);
        model.getMtvStr().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtvActivity.setText(s);
            }
        });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.activity_btn:
                model.getMtvStr().setValue("我是从Activity发出的Post");
                break;
            default:
                break;

        }
    }
}
