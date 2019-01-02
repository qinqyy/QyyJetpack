package com.example.qyy.mydatabinding.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Fruit {
    @PrimaryKey
    public Integer fruitid;
    public String name;
}
