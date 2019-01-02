package com.example.qyy.mydatabinding.room;

import android.arch.persistence.room.ColumnInfo;

public class Address {
    public String city;
    @ColumnInfo(name = "post_code")
    public Integer postCode;
}
