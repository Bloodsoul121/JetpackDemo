package com.blood.jetpackdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.room.AppDatabase;
import com.blood.jetpackdemo.room.User;
import com.blood.jetpackdemo.room.UserDao;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class RoomActivity extends AppCompatActivity {

    private UserDao mUserDao;

    private final Random mRandom = new Random();

    private TextView mContentView;

    private User mLastUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mContentView = findViewById(R.id.content);

        mUserDao = AppDatabase.getInstance().getUserDao();
    }

    public void insert(View view) {
        User user = new User(mRandom.nextInt(1000));
        user.name = "name" + mRandom.nextInt(100);
        user.age = mRandom.nextInt(50);
        user.vip = mRandom.nextBoolean();
        user.birthday = new Date(System.currentTimeMillis()).getTime();
        mUserDao.insertUsers(user);
        mLastUser = user;
    }

    public void insertSample(View view) {
        mLastUser.name = "name" + mRandom.nextInt(100);
        mLastUser.age = mRandom.nextInt(50);
        mLastUser.vip = mRandom.nextBoolean();
        mUserDao.insertUsers(mLastUser);
    }

    public void queryAll(View view) {
        StringBuilder sb = new StringBuilder();
        List<User> allUsers = mUserDao.queryAllUsers();
        for (User user : allUsers) {
            sb.append(user.toString()).append("\n");
        }
        mContentView.setText(sb);
    }

    public void update(View view) {
        if (mLastUser == null) {
            Toast.makeText(this, "先插入数据", Toast.LENGTH_SHORT).show();
            return;
        }
        mLastUser.name = "name" + mRandom.nextInt(100);
        mLastUser.age = mRandom.nextInt(50);
        mLastUser.vip = mRandom.nextBoolean();
        mUserDao.updataUsers(mLastUser);
    }

    public void delete(View view) {
        mUserDao.deleteAllUsers();
    }

    public void queryAllBetweenAge(View view) {
        // RoomTrackingLiveData -> postValue 自动通知刷新
        LiveData<List<User>> listLiveData = mUserDao.queryUserForProperty(10, 40);
        listLiveData.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                StringBuilder sb = new StringBuilder();
                sb.append("onChanged").append("\n");
                for (User user : users) {
                    sb.append(user.toString()).append("\n");
                }
                mContentView.setText(sb);
            }
        });
    }

    public void queryAllBetweenBirthday(View view) {
        Date from = new Date(System.currentTimeMillis() - 1000 * 60 * 60);
        Date to = new Date(System.currentTimeMillis());
        List<User> users = mUserDao.queryUserForBirthday(from, to);
        StringBuilder sb = new StringBuilder();
        sb.append("Birthday").append("\n");
        for (User user : users) {
            sb.append(user.toString()).append("\n");
        }
        mContentView.setText(sb);
    }
}