package com.blood.jetpackdemo.paging;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.blood.jetpackdemo.BR;
import com.blood.jetpackdemo.R;

public class ShoeAdapter extends PagedListAdapter<Shoe, ShoeAdapter.ViewHolder> {

    public ShoeAdapter(@NonNull ShoeDiffCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_shoe, parent, false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shoe shoe = getItem(position);
        holder.mBinding.setVariable(BR.shoe, shoe);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding mBinding;

        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
