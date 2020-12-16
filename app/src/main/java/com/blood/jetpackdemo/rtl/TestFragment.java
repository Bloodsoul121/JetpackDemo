package com.blood.jetpackdemo.rtl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blood.jetpackdemo.R;

import java.util.Random;

public class TestFragment extends Fragment {

    private View mRootView;
    private TextView mTv;

    private Random mRandom = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_test_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTv = mRootView.findViewById(R.id.tv);
        mTv.setText("" + mRandom.nextInt());
    }
}
