package com.example.qyy.mydatabinding.paging;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PageDao {
    @Insert
    void insertList(List<Page> mlist);

    @Query("SELECT * FROM page")
    List<Page> getmypage();
}
