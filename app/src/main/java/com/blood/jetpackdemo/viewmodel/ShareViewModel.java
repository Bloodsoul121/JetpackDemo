package com.blood.jetpackdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private final MutableLiveData<Data> mLiveData = new MutableLiveData<>();

    private final Data mData = new Data();

    public Data getData() {
        return mData;
    }

    public MutableLiveData<Data> getLiveData() {
        return mLiveData;
    }

    public void setValue(Data value) {
        mLiveData.setValue(value);
    }

}
