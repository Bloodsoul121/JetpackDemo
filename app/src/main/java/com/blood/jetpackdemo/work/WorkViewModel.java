package com.blood.jetpackdemo.work;

import androidx.lifecycle.ViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.blood.jetpackdemo.MainApplication;

public class WorkViewModel extends ViewModel {

    private static final String TAG = "WorkViewModel";

    private final WorkManager mWorkManager = WorkManager.getInstance(MainApplication.getContext());

    public void addWork() {
        OneTimeWorkRequest request = OneTimeWorkRequest.from(CleanUpWorker.class);
        mWorkManager.enqueue(request);
    }

}
