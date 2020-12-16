package com.blood.jetpackdemo.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = false)
    public int uid;

    @ColumnInfo(name = "user_name")
    public String name;

    @ColumnInfo(defaultValue = "18")
    public int age;

    @ColumnInfo(defaultValue = "1")
    public int level;

//    @ColumnInfo(defaultValue = "1")
//    public int sex;
//
//    @ColumnInfo(defaultValue = "10")
//    public int coin;

    @ColumnInfo(defaultValue = "0")
    public long birthday;

    @Ignore
    public boolean vip;

    public User(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", birthday=" + birthday +
//                ", sex=" + sex +
//                ", coin=" + coin +
                ", vip=" + vip +
                '}';
    }
}
