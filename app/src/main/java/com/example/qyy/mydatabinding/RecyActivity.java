package com.example.qyy.mydatabinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.qyy.mydatabinding.bean.User;
import com.example.qyy.mydatabinding.databinding.ActivityRecyBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyActivity extends AppCompatActivity implements View.OnClickListener {
    private List<User> mlist = new ArrayList<>();
    private ActivityRecyBinding binding;
    private RecyViewModel recyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recy);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new RecyclerBaseAdapter<User, RecyItmeVh>(null, this) {
            @Override
            public int getTypeLayoutId(int position) {
                if (position > 10) {
                    return R.layout.itme_recy;
                } else {
                    return R.layout.itme_two;
                }
            }

            @Override
            public RecyItmeVh getItmeViewModel(MyViewHodler viewHodler, int position) {
                return new RecyItmeVh(mlist.get(position));
            }

        });
        getuser();
        recyViewModel = new RecyViewModel(mlist);
        binding.setViewmodel(recyViewModel);
    }

    private void getuser() {
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName("魏无羡" + i);
            mlist.add(user);
        }
    }


    @Override
    public void onClick(View v) {
        mlist.clear();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setName("薛洋" + i);
            mlist.add(user);
        }
        recyViewModel.notifyChange();

        Intent intent = new Intent(this, LifecyclesActivity.class);
        startActivity(intent);
    }
}
