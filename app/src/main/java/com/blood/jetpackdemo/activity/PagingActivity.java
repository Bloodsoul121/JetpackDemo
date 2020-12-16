package com.blood.jetpackdemo.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blood.jetpackdemo.R;
import com.blood.jetpackdemo.databinding.ActivityPagingBinding;
import com.blood.jetpackdemo.paging.Shoe;
import com.blood.jetpackdemo.paging.ShoeAdapter;
import com.blood.jetpackdemo.paging.ShoeDao;
import com.blood.jetpackdemo.paging.ShoeDiffCallback;
import com.blood.jetpackdemo.paging.ShoeViewModel;
import com.blood.jetpackdemo.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PagingActivity extends AppCompatActivity {

    private ShoeDao mShoeDao;

    private final Random mRandom = new Random();

    private ActivityPagingBinding mBinding;
    private ShoeAdapter mShoeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging);

        mShoeDao = AppDatabase.getInstance().getShoeDao();

        initDatabase();
        initView();
    }

    private void initDatabase() {
        List<Shoe> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Shoe shoe = new Shoe();
            shoe.id = i;
            shoe.name = "" + i;
            shoe.price = mRandom.nextInt(200);
            list.add(shoe);
        }
        mShoeDao.deleteAllShoes();
        mShoeDao.insertShoes(list);
    }

    private void initView() {
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mShoeAdapter = new ShoeAdapter(new ShoeDiffCallback());
        mBinding.recyclerview.setAdapter(mShoeAdapter);

        ShoeViewModel shoeViewModel = new ViewModelProvider(this, new ShoeViewModel.ViewModeFactory(mShoeDao)).get(ShoeViewModel.class);
        shoeViewModel.getShoes().observe(this, shoes -> mShoeAdapter.submitList(shoes));
    }

}