package com.example.qyy.mydatabinding.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MyEntivity.class, Fruit.class}, version = 4)
public abstract class MyDataBase extends RoomDatabase {
    public abstract MyDao getmydao();
}
