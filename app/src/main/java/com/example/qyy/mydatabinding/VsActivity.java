package com.example.qyy.mydatabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VsActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewStub viewStub;
    private View vsc;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);
        viewStub = (ViewStub) findViewById(R.id.viewstud);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_show:
                try {
                    viewStub.inflate();
                    vsc = (View) findViewById(R.id.vv);
                    tv = (TextView) vsc.findViewById(R.id.tv);
                }catch (Exception e){

                }

//                viewStub.setVisibility(View.VISIBLE);

                break;
            case R.id.btn_unshow:
                viewStub.setVisibility(View.GONE);
                Toast.makeText(this, " " + tv.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_onshow:
                viewStub.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_vs:
                Toast.makeText(this, "点击View " + tv.getText(), Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
