package com.blood.jetpackdemo.paging;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShoeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoes(Shoe... shoes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShoes(List<Shoe> list);

    @Query("SELECT * FROM shoes WHERE id BETWEEN :start AND :end")
    List<Shoe> queryShoes(int start, int end);

    @Query("DELETE FROM shoes")
    void deleteAllShoes();

    @Query("SELECT * FROM shoes")
    DataSource.Factory<Integer, Shoe> queryShoes();

}
