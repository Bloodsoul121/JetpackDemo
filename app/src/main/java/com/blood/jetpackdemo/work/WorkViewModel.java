package com.blood.jetpackdemo.work;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.blood.jetpackdemo.MainApplication;

public class WorkViewModel extends ViewModel {

    private static final String TAG = "WorkViewModel";

    private final WorkManager mWorkManager = WorkManager.getInstance(MainApplication.getContext());

    public void addWork() {

        Log.i(TAG, Thread.currentThread().getName() + " addWork");

//        OneTimeWorkRequest request = OneTimeWorkRequest.from(CleanUpWorker.class);
//        mWorkManager.enqueue(request);

        // 任务链
//        mWorkManager.beginWith().then().enqueue();
//        mWorkManager.beginUniqueWork().then().enqueue();

        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true) // 非电池低电量
                .setRequiredNetworkType(NetworkType.CONNECTED) // 网络连接的情况
                .setRequiresStorageNotLow(true) // 存储空间足
                .setRequiresCharging(false)
//                .setRequiresDeviceIdle(true)
                .build();
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(CleanUpWorker.class)
                .setConstraints(constraints)
                .addTag("CleanUpWorker")
                .build();
        mWorkManager.enqueueUniqueWork("CleanUpWorker", ExistingWorkPolicy.REPLACE, workRequest);

//        mWorkManager.cancelUniqueWork("CleanUpWorker");
    }

}
