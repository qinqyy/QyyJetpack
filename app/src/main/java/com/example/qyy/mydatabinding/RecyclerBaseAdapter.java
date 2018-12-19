package com.example.qyy.mydatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class RecyclerBaseAdapter<T, VH> extends RecyclerView.Adapter<RecyclerBaseAdapter.MyViewHodler> {
    private List<T> mlist;
    private Context mcontext;

    public RecyclerBaseAdapter(List<T> datalist, Context context) {
        mlist = datalist;
        mcontext = context;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(mcontext), i, viewGroup, false);
        MyViewHodler myViewHodler = new MyViewHodler(viewDataBinding);
        return myViewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler myViewHodler, int i) {
        Object itmevh = getItmeViewModel(myViewHodler, i);
        myViewHodler.setviewmodel(itmevh);
    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getTypeLayoutId(position);
    }

    public abstract int getTypeLayoutId(int position);

    public abstract VH getItmeViewModel(MyViewHodler viewHodler, int position);

    /**
     * 必须public static
     */
    public static class MyViewHodler extends RecyclerView.ViewHolder {

        private ViewDataBinding dataBinding;

        public MyViewHodler(@NonNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            dataBinding = viewDataBinding;
        }

        public ViewDataBinding getDataBinding() {
            return dataBinding;
        }

        public void setviewmodel(Object itmemodel) {
            dataBinding.setVariable(BR.itmemodel, itmemodel);
            dataBinding.executePendingBindings();
        }

    }

    public void setData(List<T> lists) {
        mlist = lists;
        notifyDataSetChanged();
    }
}
