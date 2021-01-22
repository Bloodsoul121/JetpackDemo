package com.blood.jetpackdemo.activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.ActivityNavigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity implements AppBarConfiguration.OnNavigateUpListener {

    private static final String TAG = "NavigationActivity";

    private ActivityNavigationBinding mBinding;
    private NavController mNavController;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);

        Menu menu = mBinding.bottomNavigationView.getMenu();
        Log.i(TAG, "onCreate: " + menu);

        // 交给 NavigationUI 管控
//        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                String title = item.getTitle().toString();
//                Log.i(TAG, "onNavigationItemSelected: " + title);
//                return true;
//            }
//        });

        mBinding.bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                Log.i(TAG, "onNavigationItemReselected: " + title);
            }
        });

//        mBinding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                String title = item.getTitle().toString();
//                Log.i(TAG, "onNavigationItemSelected: " + title);
//                return true;
//            }
//        });

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(mBinding.bottomNavigationView, mNavController);
        NavigationUI.setupWithNavController(mBinding.navigationView, mNavController);

        setSupportActionBar(mBinding.toolbar);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.welcomeFragment, R.id.deepLinkFragment)
                .setOpenableLayout(mBinding.drawerLayout)
                .setFallbackOnNavigateUpListener(this)
                .build();
        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
    }

    /**
     * actionbar 必须实现这个方法
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }
}