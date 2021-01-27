package com.blood.jetpackdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.ActivityViewBindingBinding;

public class ViewBindingActivity extends AppCompatActivity {

    private ActivityViewBindingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityViewBindingBinding.inflate(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mBinding.text.setText("view binding");
    }
}