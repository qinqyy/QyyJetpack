package com.example.qyy.mydatabinding.livedata.transformation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class MapActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbtn;
    private TextView mtv;
    public MutableLiveData<String> a = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mbtn = (Button) findViewById(R.id.btn_map_one);
        mtv = (TextView) findViewById(R.id.tv_activity);
        a.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtv.setText(s);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_map_one, MapFragment.newInstance()).commit();
    }

    @Override
    public void onClick(View v) {
        a.setValue("我是小格子女生");
    }
}
