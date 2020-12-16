package com.blood.jetpackdemo.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

// 访问数据库操作的接口 Database access object

@Dao
public interface UserDao {

    //我们所有对数据库的操作都在Dao里声明

    // 这些修饰词会在编译时候生成代码
    @Insert
    void insertUsers(User... users);   // 如果是一个参数就写 User user，多个参数就这样写

    @Update
    void updataUsers(User... users);

    @Delete
    void deleteUsers(User... users);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    // 获取所有的User，并且按照uid降序排序
    @Query("SELECT * FROM users ORDER BY uid DESC")
    List<User> queryAllUsers();

    @Query("SELECT * FROM users where uid = :uid")
    User queryUser(int uid);

    @Query("SELECT * FROM users WHERE age BETWEEN :start AND :end")
    LiveData<List<User>> queryUserForProperty(int start, int end);

    @Query("SELECT * FROM users WHERE birthday BETWEEN :from AND :to")
    List<User> queryUserForBirthday(Date from, Date to);

}
