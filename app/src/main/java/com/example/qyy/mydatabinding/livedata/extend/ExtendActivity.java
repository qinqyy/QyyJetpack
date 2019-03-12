package com.example.qyy.mydatabinding.livedata.extend;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class ExtendActivity extends AppCompatActivity implements View.OnClickListener {
    private ExtendLiveData ex = ExtendLiveData.getex();
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend);
        mtv = (TextView) findViewById(R.id.tv_str);
        ex.observe(this, new Observer<String>() {
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
            case R.id.btn_go:
                ex.set("且过当施舍");
                break;
            case R.id.btn_to:
                Intent inttwo = new Intent(this, ExtendTwoActivity.class);
                startActivity(inttwo);
                break;
            default:
                break;
        }
    }
}
