package com.blood.jetpackdemo

import android.annotation.TargetApi
import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Log

public class KtxLifeCycleCallBack : ActivityLifecycleCallbacks {

    private val TAG: String = "KtxLifeCycleCallBack"

    fun String.loge() {
        Log.i(TAG, this)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        "onActivityCreated : ${activity.localClassName}".loge()
    }

    override fun onActivityStarted(activity: Activity) {
        "onActivityStarted : ${activity.localClassName}".loge()
    }

    override fun onActivityResumed(activity: Activity) {
        "onActivityResumed : ${activity.localClassName}".loge()
    }

    override fun onActivityPaused(activity: Activity) {
        "onActivityPaused : ${activity.localClassName}".loge()
    }

    override fun onActivityDestroyed(activity: Activity) {
        "onActivityDestroyed : ${activity.localClassName}".loge()
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
        "onActivitySaveInstanceState : ${activity.localClassName}".loge()
    }

    override fun onActivityStopped(activity: Activity) {
        "onActivityStopped : ${activity.localClassName}".loge()
    }
}
