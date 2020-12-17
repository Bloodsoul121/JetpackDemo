package com.blood.jetpackdemo.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.LayoutFragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private LayoutFragmentRegisterBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_register, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        String email = RegisterFragmentArgs.fromBundle(getArguments()).getEMAIL();
        mBinding.setEmail(email);
    }
}
