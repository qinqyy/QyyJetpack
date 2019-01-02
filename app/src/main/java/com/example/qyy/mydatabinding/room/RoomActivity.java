package com.example.qyy.mydatabinding.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

import java.util.ArrayList;
import java.util.List;

/**
 * room  由3个主要的组件组成：Database entity dao
 */
public class RoomActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private List<MyEntivity> myEntivityList = new ArrayList<>();
    private MyAdapter myAdapter;
    MyDao myDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        recyclerView = (RecyclerView) findViewById(R.id.room_recyclerview);
        myAdapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        myDao = DataBaseInstent.getDataBase(this).getmydao();
        LiveData<List<MyEntivity>> listLiveData = myDao.getmyentitylivadata();
        listLiveData.observe(this, new Observer<List<MyEntivity>>() {
            @Override
            public void onChanged(@Nullable List<MyEntivity> myEntivities) {
                Log.v("chchch", "数据改变");
                myEntivityList.clear();
                myEntivityList.addAll(myEntivities);
                myAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                MyEntivity myEntivity = new MyEntivity();
                myEntivity.age = "24岁";
                myEntivity.name = "qyy";
                Address address = new Address();
                address.postCode = 6002;
                address.city = "成都";
                myEntivity.address = address;
                myDao.insertEntity(myEntivity);
                break;
            case R.id.btn_addboth:
                MyEntivity myEntivity1 = new MyEntivity();
                myEntivity1.age = "28岁";
                myEntivity1.name = "qyytwo";
                Address address1 = new Address();
                address1.postCode = 6002;
                address1.city = "成都";
                myEntivity1.address = address1;

                MyEntivity myEntivity2 = new MyEntivity();
                myEntivity2.age = "28岁";
                myEntivity2.name = "qyytwo";
                Address address2 = new Address();
                address2.postCode = 6002;
                address2.city = "成都";
                myEntivity2.address = address2;
                myDao.insertBoth(myEntivity1, myEntivity2);
                break;
            case R.id.btn_addlist:
                List<MyEntivity> mylist = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    MyEntivity my = new MyEntivity();
                    my.age = "20岁";
                    my.name = "qyy";
                    Address add = new Address();
                    add.postCode = 6002;
                    add.city = "成都";
                    my.address = add;
                    mylist.add(my);
                }
                myDao.insertList(mylist);
                break;
            case R.id.btn_adds:
                MyEntivity mm = new MyEntivity();
                mm.age = "28岁";
                mm.name = "qyytwo";
                Address aa = new Address();
                aa.postCode = 6002;
                aa.city = "成都";
                mm.address = aa;

                MyEntivity yy = new MyEntivity();
                yy.age = "28岁";
                yy.name = "qyytwo";
                Address dd = new Address();
                dd.postCode = 6002;
                dd.city = "成都";
                yy.address = dd;
                MyEntivity[] mys = new MyEntivity[]{mm, yy};
                myDao.insertMyentitys(mys);
                break;
            case R.id.btn_query:
//               myDao.getmyentitylivadata();
                break;
            case R.id.btn_delectall:
                myDao.delectqyyall();
                break;
            default:
                break;
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVh> {

        @NonNull
        @Override
        public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
            MyVh myVh = new MyVh(view);
            return myVh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyVh myVh, final int i) {
            myVh.mtvid.setText("" + myEntivityList.get(i).keyid);
            myVh.mtvage.setText("" + myEntivityList.get(i).age);
            myVh.mtvname.setText("" + myEntivityList.get(i).name);
            myVh.itme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyEntivity myEntivityole = myEntivityList.get(i);
                    MyEntivity myEntivitynew = new MyEntivity();
                    myEntivitynew.keyid = myEntivityole.keyid;
                    myEntivitynew.address = myEntivityole.address;
                    myEntivitynew.name = "我是更新后的";
                    myEntivitynew.age = "22岁";
                    myDao.updateEntity(myEntivitynew);
                }
            });
            myVh.itme.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    MyEntivity mmy = myEntivityList.get(i);
                    myDao.delectHEntity(mmy);
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return myEntivityList.size();
        }

        public class MyVh extends RecyclerView.ViewHolder {
            private TextView mtvname;
            private TextView mtvage;
            private TextView mtvid;
            private View itme;

            public MyVh(@NonNull View itemView) {
                super(itemView);
                mtvname = (TextView) itemView.findViewById(R.id.tv_name);
                mtvage = (TextView) itemView.findViewById(R.id.tv_age);
                mtvid = (TextView) itemView.findViewById(R.id.tv_id);
                itme = itemView;

            }
        }
    }
}
