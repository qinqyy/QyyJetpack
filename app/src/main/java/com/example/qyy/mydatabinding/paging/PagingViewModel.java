package com.example.qyy.mydatabinding.paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

public class PagingViewModel extends ViewModel {
    public LiveData<PagedList<Page>> mlist;

    public LiveData<PagedList<Page>> getMlist() {
        return mlist;
    }

    public void setMlist(LiveData<PagedList<Page>> mlist) {
        this.mlist = mlist;
    }
}
