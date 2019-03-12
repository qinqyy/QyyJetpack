package com.example.qyy.mydatabinding.livedata.extend;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class ExtendTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private ExtendLiveData exd = ExtendLiveData.getex();
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_two);
        mtv = (TextView) findViewById(R.id.tv_two);
        exd.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtv.setText(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_two:
                exd.set("我的躯壳");
                break;
            default:
                break;
        }
    }
}
