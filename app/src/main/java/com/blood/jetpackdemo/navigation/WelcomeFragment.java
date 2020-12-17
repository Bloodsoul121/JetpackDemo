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
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.LayoutFragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    private LayoutFragmentWelcomeBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_welcome, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 设置动画参数
                NavOptions navOptions = new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right)
                        .build();

                // 参数设置
                Bundle bundle = new Bundle();
                bundle.putString("name", "TeaOf");
                Navigation.findNavController(mBinding.getRoot()).navigate(R.id.loginFragment, bundle, navOptions);
            }
        });

        mBinding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Safe Args
                WelcomeFragmentDirections.ActionWelcomeFragmentToRegisterFragment action = WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment()
                        .setEMAIL("TeaOf1995@Gamil.com");
                Navigation.findNavController(mBinding.getRoot()).navigate(action);
            }
        });
    }
}
