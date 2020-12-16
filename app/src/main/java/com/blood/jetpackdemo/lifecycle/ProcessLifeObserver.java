package com.blood.jetpackdemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ProcessLifeObserver implements LifecycleObserver {

    private static final String TAG = "ProcessLifeObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppBackground() {
        // 应用进入后台
        Log.e(TAG, "ProcessLifeObserver onAppBackground ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppForeground() {
        // 应用进入前台
        Log.e(TAG, "ProcessLifeObserver onAppForeground ON_START");

    }

}
