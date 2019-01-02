package com.example.qyy.mydatabinding.livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.qyy.mydatabinding.R;
import com.example.qyy.mydatabinding.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {
    private LiveViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLiveDataBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_one, LiveOneFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_two, LiveTwoFragment.newInstance()).commit();
        model = ViewModelProviders.of(this).get(LiveViewModel.class);
        dataBinding.setViewodel(model);
        dataBinding.setLifecycleOwner(this);
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
