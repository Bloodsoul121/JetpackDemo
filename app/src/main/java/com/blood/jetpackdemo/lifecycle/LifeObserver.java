package com.blood.jetpackdemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifeObserver implements LifecycleObserver {

    private static final String TAG = "LifeObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateListener() {
        Log.d(TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartListener() {
        Log.d(TAG, "onStart: ");
    }

    // OnLifecycleEvent()内的注解Lifecycle.Event.XXX 对应不同的生命周期方法，你可以根据需要监听不同的生命周期方法。
    // 方法名可以随意，这里为了方便理解定义为onResumeListener()。
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeListener() {
        Log.d(TAG, "onResume: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseListener() {
        Log.d(TAG, "onPause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestoryListener() {
        Log.d(TAG, "onDestory: ");
    }

}
