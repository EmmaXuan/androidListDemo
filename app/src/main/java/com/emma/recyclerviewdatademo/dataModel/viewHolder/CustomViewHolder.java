package com.emma.recyclerviewdatademo.dataModel.viewHolder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    protected final ViewDataBinding binding;

    public CustomViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding =  binding;
    }

    public CustomViewHolder setBinding(int variableId , Object vo){
        binding.setVariable(variableId , vo);
        binding.executePendingBindings();
        return this;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

}