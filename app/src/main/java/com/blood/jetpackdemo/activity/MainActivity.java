package com.blood.jetpackdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blood.jetpackdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void clickBtn1(View view) {
        startActivity(new Intent(this, JetPackActivity.class));
    }

    public void clickBtn2(View view) {
        startActivity(new Intent(this, RoomActivity.class));
    }

    public void clickBtn3(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));
    }

    public void clickBtn4(View view) {
        startActivity(new Intent(this, PagingActivity.class));
    }

    public void clickBtn5(View view) {
        startActivity(new Intent(this, NavigationActivity.class));
    }

    public void clickBtn6(View view) {
        startActivity(new Intent(this, CoroutinesActivity.class));
    }
}