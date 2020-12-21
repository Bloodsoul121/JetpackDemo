package com.blood.jetpackdemo.work;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.List;

public class BlurWorker extends Worker {

    private static final String TAG = "BlurWorker";

    private static final String TAG_BLUR_WORK = "tag_blur_work";

    public static final String KEY_ID = "key_id";

    public BlurWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    public static void addWork(AppCompatActivity activity) {
        OneTimeWorkRequest blurWorkRequest = new OneTimeWorkRequest.Builder(BlurWorker.class)
                .setInputData(new Data.Builder().putInt("id", 123).build())
                .addTag(TAG_BLUR_WORK)
                .build();
        WorkManager.getInstance(activity).beginWith(blurWorkRequest).enqueue();

        LiveData<List<WorkInfo>> liveData = WorkManager.getInstance(activity).getWorkInfosByTagLiveData(TAG_BLUR_WORK);
        liveData.observe(activity, new Observer<List<WorkInfo>>() {
            @Override
            public void onChanged(List<WorkInfo> workInfos) {
                for (WorkInfo info : workInfos) {
                    Log.i(TAG, "onChanged: " + info.getId() + info.getState());
                }
            }
        });
    }

    @NonNull
    @Override
    public Result doWork() {
        try {

            // do blur
            Log.i(TAG, "doWork: blur");

            Data data = getInputData();
            int id = data.getInt(KEY_ID, 0);
            Log.i(TAG, "doWork: blur id " + id);

            return Result.success();
        } catch (Exception e) {
            return Result.failure();
        }
    }
}
