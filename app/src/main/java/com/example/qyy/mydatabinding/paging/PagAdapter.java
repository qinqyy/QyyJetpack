package com.example.qyy.mydatabinding.paging;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qyy.mydatabinding.R;

import java.util.List;

public class PagAdapter extends RecyclerView.Adapter<PagAdapter.ViewhodlerPag> {
    private List<Page> mlist;
    private Context mcontext;

    public PagAdapter(List<Page> list, Context context) {
        mlist = list;
        mcontext = context;
    }

    @NonNull
    @Override
    public ViewhodlerPag onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.page_itme, null);
        ViewhodlerPag viewhodlerPag = new ViewhodlerPag(view);
        return viewhodlerPag;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhodlerPag viewhodlerPag, int i) {
        viewhodlerPag.tv.setText("ID: " + mlist.get(i).pagId + " 内容：" + mlist.get(i).content);
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewhodlerPag extends RecyclerView.ViewHolder {
        private TextView tv;

        public ViewhodlerPag(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_page);
        }
    }
}
