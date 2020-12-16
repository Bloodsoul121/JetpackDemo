package com.blood.jetpackdemo.paging;


import androidx.annotation.NonNull;
import androidx.paging.DataSource;

public class CustomPageDataSourceFactory extends DataSource.Factory<Integer, Shoe> {

    private final ShoeDao mShoeDao;

    public CustomPageDataSourceFactory(ShoeDao shoeDao) {
        mShoeDao = shoeDao;
    }

    @NonNull
    @Override
    public DataSource<Integer, Shoe> create() {
        return new CustomPageDataSource(mShoeDao);
    }
}
