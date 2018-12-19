package com.example.qyy.mydatabinding.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class ViewModelActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mtv;
    private TextView mtvq;
    private TextView mtvmy;
    MyViewModel myViewModel;
    MyAndroidViewModel myAndroidViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        mtv = (TextView) findViewById(R.id.tv);
        mtvq = (TextView) findViewById(R.id.tv_q);
        mtvmy = (TextView) findViewById(R.id.tv_my);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getM().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtv.setText(s);
                Log.v("xxxxxx", "onChanged" + s);
            }
        });

        myAndroidViewModel = ViewModelProviders.of(this).get(MyAndroidViewModel.class);
        myAndroidViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtvmy.setText(s);
                Log.v("xxxxxx", "onChanged" + s);
            }
        });
        Log.v("xxxxxx", "onCreate" + myViewModel.toString());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_change:
                myViewModel.getM().setValue("轻轻贴着耳朵~");
                mtvq.setText("cbdbdhfbbb");
                myAndroidViewModel.getName().setValue("assssss");
                myViewModel.setAge("24");
                break;
            case R.id.btn_show:
                String mm = myViewModel.getM().getValue();
                myViewModel.getM().setValue(mm + "旋转");
                mtvmy.setText(myViewModel.getAge());
                break;
            default:
                break;
        }
    }
}
