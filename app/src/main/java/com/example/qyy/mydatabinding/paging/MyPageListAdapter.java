package com.example.qyy.mydatabinding.paging;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

public class MyPageListAdapter extends PagedListAdapter<Page, MyPageListAdapter.MyPageViewHodel> {

    protected MyPageListAdapter() {
        super(Diff);
    }

    @NonNull
    @Override
    public MyPageViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.page_itme, null);
        MyPageViewHodel viewhodlerPag = new MyPageViewHodel(view);
        return viewhodlerPag;
    }

    @Override
    public void onBindViewHolder(@NonNull MyPageViewHodel myPageViewHodel, int i) {
        Page page = getItem(i);
        if (page != null) {
            myPageViewHodel.tv.setText("" + page.content);
        }

    }

    private static DiffUtil.ItemCallback<Page> Diff = new DiffUtil.ItemCallback<Page>() {
        @Override
        public boolean areItemsTheSame(@NonNull Page page, @NonNull Page t1) {
            return page.pagId == t1.pagId;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Page page, @NonNull Page t1) {
            return page.equals(t1);

        }
    };

    class MyPageViewHodel extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyPageViewHodel(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_page);
        }
    }
}
