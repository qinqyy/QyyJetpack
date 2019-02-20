package com.example.qyy.mydatabinding.paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private PagingViewModel viewModel;
    private LiveData<PagedList<Page>> listpage;
    private MyPageListAdapter myPageListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        mrecy = (RecyclerView) findViewById(R.id.recy);
        mtv = (TextView) findViewById(R.id.tv);
        adapter = new PagAdapter(mlist, this);
        mrecy.setLayoutManager(new LinearLayoutManager(this));
//        mrecy.setAdapter(adapter);
        getdatabase();
        Button button = findViewById(R.id.btn_add);
        viewModel = ViewModelProviders.of(this).get(PagingViewModel.class);
        myPageListAdapter = new MyPageListAdapter();
        mrecy.setAdapter(myPageListAdapter);


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
                for (int i = 0; i < 5000; i++) {
                    Page page = new Page();
                    page.content = "我的Itme是：" + i;
                    mlistadd.add(page);
                }
                dataBase.getdao().insertList(mlistadd);
                mtv.setText("完成");
                break;
            case R.id.btn_qer:
                Page page = new Page();
                page.pagId = 2;
                page.content = "bvbdhfdbhfvhf";
                dataBase.getdao().toUpdate(page);
//                mlist.clear();
//                mlist.addAll(dataBase.getdao().getmypage());
//                adapter.notifyDataSetChanged();
//                mtv.setText("加载完成");
                break;
            case R.id.btn_paging_qer:
                listpage = new LivePagedListBuilder<>(dataBase.getdao().getall(), 100)
                        .setBoundaryCallback(new PagedList.BoundaryCallback<Page>() {
                            @Override
                            public void onZeroItemsLoaded() {
                                super.onZeroItemsLoaded();
                                Log.v("cdcddd", "加载：" + "onZeroItemsLoaded");
                            }

                            @Override
                            public void onItemAtFrontLoaded(@NonNull Page itemAtFront) {
                                super.onItemAtFrontLoaded(itemAtFront);
                                Log.v("cdcddd", "外面we：" + "onItemAtFrontLoaded");
                            }

                            @Override
                            public void onItemAtEndLoaded(@NonNull Page itemAtEnd) {
                                super.onItemAtEndLoaded(itemAtEnd);
                                Log.v("cdcddd", "外面：" + "onItemAtEndLoaded");
                            }
                        })
                        .build();
                viewModel.setMlist(listpage);
                viewModel.getMlist().observe(this, new Observer<PagedList<Page>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<Page> pages) {
                        myPageListAdapter.submitList(pages);
                    }
                });
                break;
            default:
                break;
        }
    }
}
