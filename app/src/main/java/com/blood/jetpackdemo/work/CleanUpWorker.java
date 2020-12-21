package com.blood.jetpackdemo.work;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CleanUpWorker extends Worker {

    private static final String TAG = "CleanUpWorker";

    public CleanUpWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {

            // do clean
            Log.i(TAG, "doWork: CleanUp");

            return Result.success();
        } catch (Exception e) {
            return Result.failure();
        }
    }
}
