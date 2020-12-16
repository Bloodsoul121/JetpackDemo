package com.blood.jetpackdemo.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class ShoeViewModel extends ViewModel {

    private final LiveData<PagedList<Shoe>> mShoes;

    public ShoeViewModel(ShoeDao shoeDao) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .build();

        // 非room数据库
//        mShoes = new LivePagedListBuilder<>(new CustomPageDataSourceFactory(shoeDao), config).build();

        // 配合room，只需要 shoeDao.queryShoes()
        mShoes = new LivePagedListBuilder<>(shoeDao.queryShoes(), config).build();
    }

    public LiveData<PagedList<Shoe>> getShoes() {
        return mShoes;
    }

    public static class ViewModeFactory implements ViewModelProvider.Factory {

        private final ShoeDao mShoeDao;

        public ViewModeFactory(ShoeDao shoeDao) {
            mShoeDao = shoeDao;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ShoeViewModel(mShoeDao);
        }
    }
}
