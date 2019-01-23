package com.example.qyy.mydatabinding.paging;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "page")
public class Page {
    @PrimaryKey(autoGenerate = true)
    public int pagId;

    public String content;

}
