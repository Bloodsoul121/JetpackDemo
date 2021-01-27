package com.blood.jetpackdemo.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.work.WorkViewModel;

public class WorkManagerActivity extends AppCompatActivity {

    private WorkViewModel mWorkViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        mWorkViewModel = new ViewModelProvider(this).get(WorkViewModel.class);
    }

    public void clickBtn1(View view) {
        mWorkViewModel.addWork();
    }
}