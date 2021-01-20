package com.blood.jetpackdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.ActivityNavigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity {

    private static final String TAG = "NavigationActivity";

    private ActivityNavigationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);

        Menu menu = mBinding.bottomNavigationView.getMenu();
        Log.i(TAG, "onCreate: " + menu);

        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                switch (item.getItemId()) {
                    case R.id.home_dest:
                        Log.i(TAG, "onNavigationItemSelected: " + title);
                        break;
                    case R.id.deeplink_dest:
                        Log.i(TAG, "onNavigationItemSelected: " + title);
                        break;
                }
                return true;
            }
        });

        mBinding.bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                switch (item.getItemId()) {
                    case R.id.home_dest:
                        Log.i(TAG, "onNavigationItemReselected: " + title);
                        break;
                    case R.id.deeplink_dest:
                        Log.i(TAG, "onNavigationItemReselected: " + title);
                        break;
                }
            }
        });

        mBinding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                Log.i(TAG, "onNavigationItemSelected: " + title);
                return true;
            }
        });
    }
}