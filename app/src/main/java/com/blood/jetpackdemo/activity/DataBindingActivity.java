package com.blood.jetpackdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.ActivityDatabindingBinding;
import com.blood.jetpackdemo.databinding.BindViewModel;
import com.blood.jetpackdemo.databinding.ViewModelA;

public class DataBindingActivity extends AppCompatActivity {

    private static final String TAG = "DataBindingActivity";

    public ActivityDatabindingBinding mDataBinding;
    private BindViewModel mBindViewModel;
    private ViewModelA viewModelA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        mDataBinding.setText1("hello");
        mDataBinding.setText2(null);

        mDataBinding.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506868893&di=ce03509d972bd0d535a1fdcc20c9d202&imgtype=jpg&er=1&src=http%3A%2F%2Fn.sinaimg.cn%2Fent%2Ftransform%2F20170818%2FIAPS-fykcppx9377606.jpg");

        mBindViewModel = new BindViewModel(mDataBinding);
        mDataBinding.setListener1(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mDataBinding.setImgcolor(getResources().getColor(R.color.purple_500));

        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue("liveData");
        mDataBinding.setLiveText(liveData);
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i(TAG, "onChanged: LiveText " + s);
            }
        });
        mDataBinding.tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBinding.tv5.setText("click self");
            }
        });


        mDataBinding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //生成ViewModel对象，将MainActivity对象传进去，待其内部调用
                viewModelA = new ViewModelA(DataBindingActivity.this);
                //为了让数据更新与用户操作（点击、滑动）相互相应，这个步骤一定要做
                mDataBinding.setViewModel(viewModelA);
            }
        });
        mDataBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModelA != null)
                    viewModelA.add();
            }
        });
        mDataBinding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModelA != null)
                    viewModelA.remove();
            }
        });
        mDataBinding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModelA != null)
                    viewModelA.update();
            }
        });
    }
}