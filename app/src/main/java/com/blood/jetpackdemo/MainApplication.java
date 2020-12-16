package com.blood.jetpackdemo;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.blood.jetpackdemo.lifecycle.ProcessLifeObserver;

import leakcanary.LeakCanary;

public class MainApplication extends Application {

    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ProcessLifeObserver());

        registerActivityLifecycleCallbacks(new KtxLifeCycleCallBack());
    }

    public static Context getContext() {
        return mApplication.getApplicationContext();
    }
}
