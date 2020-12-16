package com.blood.jetpackdemo.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

public class CustomPageDataSource extends PageKeyedDataSource<Integer, Shoe> {

    private static final String TAG = "CustomPageDataSource";

    private final ShoeDao mShoeDao;

    public CustomPageDataSource(ShoeDao shoeDao) {
        mShoeDao = shoeDao;
    }

    // 第一次加载的时候调用
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Shoe> callback) {
        Log.i(TAG, "loadInitial: " + params.requestedLoadSize + " , " + params.placeholdersEnabled);
        int startIndex = 0;
        int endIndex = params.requestedLoadSize;
        List<Shoe> list = mShoeDao.queryShoes(startIndex, endIndex);
        callback.onResult(list, null, 2);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Shoe> callback) {
        Log.i(TAG, "loadBefore: ");
    }

    // 每次分页加载的时候调用
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Shoe> callback) {
        Log.i(TAG, "loadAfter: " + params.key + " , " + params.requestedLoadSize);
        int startPage = params.key;
        int startIndex = (startPage - 1) * params.requestedLoadSize;
        int endIndex = startIndex + params.requestedLoadSize - 1;
        List<Shoe> list = mShoeDao.queryShoes(startIndex, endIndex);
        callback.onResult(list, params.key + 1);
    }
}
