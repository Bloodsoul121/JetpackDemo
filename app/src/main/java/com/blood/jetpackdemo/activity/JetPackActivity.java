package com.blood.jetpackdemo.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.fragment.ViewModelFragment;
import com.blood.jetpackdemo.lifecycle.LifeObserver;
import com.blood.jetpackdemo.other.ThicknessTransitionPagerTitleView;
import com.blood.jetpackdemo.viewmodel.Data;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class JetPackActivity extends AppCompatActivity {

    private static final String TAG = "JetPackActivity";

    private ViewPager mViewpager;
    private MagicIndicator mIndicator;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mTabTitles = new ArrayList<>();
    private CommonNavigator mCommonNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jet_pack);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getLifecycle().addObserver(new LifeObserver());

        new Thread(new Runnable() {
            @Override
            public void run() {
                doTask();
            }
        }).start();
    }

    @MainThread
    public void doTask() {
        Log.i(TAG, "doTask " + Thread.currentThread().getName());
    }

    private void init() {
        initViewpager();
        initMagicIndicator();
    }

    private void initViewpager() {
        mViewpager = findViewById(R.id.viewpager);

        for (int i = 0; i < 5; i++) {
            mFragmentList.add(new ViewModelFragment());
        }

        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    private void initMagicIndicator() {
        mIndicator = findViewById(R.id.indicator);

        mTabTitles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mTabTitles.add("title_" + i);

        }
        mCommonNavigator = new CommonNavigator(this);
        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTabTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ThicknessTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTabTitles.get(index));
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15f);
                simplePagerTitleView.setPaddingRelative(UIUtil.dip2px(JetPackActivity.this, 14.4f), 0, UIUtil.dip2px(JetPackActivity.this, 14.4f), 0);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#ffffffff"));
                simplePagerTitleView.setNormalColor(Color.parseColor("#66ffffff"));
                simplePagerTitleView.setOnClickListener(v -> mViewpager.setCurrentItem(index));
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(JetPackActivity.this, 2.88f));
                indicator.setLineWidth(UIUtil.dip2px(JetPackActivity.this, 11.52f));
                indicator.setRoundRadius(UIUtil.dip2px(JetPackActivity.this, 3f));
                indicator.setYOffset(UIUtil.dip2px(JetPackActivity.this, 12f));
                indicator.setColors(Color.parseColor("#ffffffff"));
                return indicator;
            }
        });
        mIndicator.setNavigator(mCommonNavigator);
        ViewPagerHelper.bind(mIndicator, mViewpager);
    }

    public void clickBtn1(View view) {
        MutableLiveData<Data> dataLiveData = new MutableLiveData<>();
        dataLiveData.setValue(new Data("转换 LiveData"));
        LiveData<String> stringLiveData = Transformations.map(dataLiveData, new Function<Data, String>() {
            @Override
            public String apply(Data input) {
                return input.msg;
            }
        });
        stringLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(JetPackActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}