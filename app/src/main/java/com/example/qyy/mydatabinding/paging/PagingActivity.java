package com.example.qyy.mydatabinding.paging;

import android.arch.persistence.room.Room;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

import java.util.ArrayList;
import java.util.List;

public class PagingActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mrecy;
    private PagAdapter adapter;
    private List<Page> mlist = new ArrayList<>();
    private PageDataBase dataBase;
    private List<Page> mlistadd = new ArrayList<>();
    private TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        mrecy = (RecyclerView) findViewById(R.id.recy);
        mtv = (TextView) findViewById(R.id.tv);
        adapter = new PagAdapter(mlist, this);
        mrecy.setLayoutManager(new LinearLayoutManager(this));
        mrecy.setAdapter(adapter);
        getdatabase();

    }


    private void getdatabase() {
        dataBase = Room.databaseBuilder(this, PageDataBase.class, "qyypage")
                .allowMainThreadQueries()
                .build();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                for (int i = 0; i < 1000; i++) {
                    Page page = new Page();
                    page.content = "我的Itme是：" + i;
                    mlistadd.add(page);
                }
                dataBase.getdao().insertList(mlistadd);
                break;
            case R.id.btn_qer:
                mlist.clear();
                mlist.addAll(dataBase.getdao().getmypage());
                adapter.notifyDataSetChanged();
                mtv.setText("加载完成");
                break;
            default:
                break;
        }
    }
}
