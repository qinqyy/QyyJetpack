package com.example.qyy.mydatabinding.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    void insertEntity(MyEntivity myEntivity);

    @Insert
    void insertBoth(MyEntivity myEntivityone, MyEntivity myEntivitytwo);

    @Insert
    void insertList(List<MyEntivity> myEntivityList);

    @Insert
    void insertMyentitys(MyEntivity[] myEntivities);

    @Update
    void updateEntity(MyEntivity myEntivity);

    @Delete
    void delectHEntity(MyEntivity myEntivity);

    @Delete
    void delectall(List<MyEntivity> mlist);

    @Query("SELECT * FROM qyy")
    List<MyEntivity> getmyentity();

    @Query("SELECT * FROM qyy")
    LiveData<List<MyEntivity>> getmyentitylivadata();

    @Query("DELETE FROM qyy")
    void delectqyyall();

}
