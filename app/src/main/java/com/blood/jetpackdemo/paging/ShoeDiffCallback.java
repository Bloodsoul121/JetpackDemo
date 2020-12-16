package com.blood.jetpackdemo.paging;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class ShoeDiffCallback extends DiffUtil.ItemCallback<Shoe> {
    @Override
    public boolean areItemsTheSame(@NonNull Shoe oldItem, @NonNull Shoe newItem) {
        return oldItem.id == newItem.id;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Shoe oldItem, @NonNull Shoe newItem) {
        return Objects.equals(oldItem, newItem);
    }
}
