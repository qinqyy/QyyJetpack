package com.example.qyy.mydatabinding.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * 默认情况下 Entity的名字就是表的名字（不区分大小写）
 * 默认情况下 Entity类中字段的名字就是表中列的名字
 * 每个Entity都需要至少一个字段设置为主键
 */
@Entity(tableName = "qyy")
public class MyEntivity {
    @ColumnInfo(name = "one_name")
    public String name;
    public String age;
    public String pub_year;
    public String two;
    @PrimaryKey(autoGenerate = true)
    public Integer keyid;
    @Embedded
    public Address address;
}
