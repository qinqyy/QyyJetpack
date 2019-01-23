package com.example.qyy.mydatabinding.paging;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Page.class, version = 1)
public abstract class PageDataBase extends RoomDatabase {
    public abstract PageDao getdao();
}
