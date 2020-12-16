package com.blood.jetpackdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.viewmodel.Data;
import com.blood.jetpackdemo.viewmodel.ShareViewModel;

import java.util.Random;

public class ViewModelFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "ViewModelFragment";

    private View mRootView;
    private TextView mTv;

    private Random mRandom = new Random();
    private int mInt = mRandom.nextInt();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_view_model_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTv = mRootView.findViewById(R.id.tv);
        mTv.setText("" + mInt);
        mTv.setOnClickListener(this);

        ShareViewModel shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        shareViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                Log.i(TAG, "onChanged " + ViewModelFragment.this);
                mTv.setText(data.msg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        ShareViewModel shareViewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        Data data = shareViewModel.getData();
        data.msg = "share " + mInt;
        shareViewModel.setValue(data);
    }
}
