package com.blood.jetpackdemo.paging;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoes")
public class Shoe {

    @PrimaryKey
    public int id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public int price;

    public Shoe() {
    }
}
