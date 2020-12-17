package com.emma.recyclerviewdatademo.dataModel.viewHolder.main;

import android.view.View;

import androidx.databinding.ViewDataBinding;

import com.emma.recyclerviewdatademo.MainActivity;
import com.emma.recyclerviewdatademo.dataModel.viewHolder.CustomViewHolder;
import com.emma.recyclerviewdatademo.databinding.LayoutListItemBinding;

public class ListItemViewHolder extends CustomViewHolder {

    //如果你想回call MainActivity 裡的方法 ，就設定這個
    private MainActivity mainActivity;
    public ListItemViewHolder(ViewDataBinding binding, MainActivity mainActivity) {
        super(binding);
        this.mainActivity = mainActivity;
    }

    //不回call 其他 activity
    public ListItemViewHolder(ViewDataBinding binding) {
        super(binding);
    }

    @Override
    public CustomViewHolder setBinding(int variableId, Object vo) {
        final LayoutListItemBinding listItemBinding = (LayoutListItemBinding) binding;
        listItemBinding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.showNowClick(listItemBinding.title2.getText().toString());
            }
        });

        listItemBinding.clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemBinding.getItemVo().setImgShow(!listItemBinding.getItemVo().isImgShow());
                mainActivity.notifyList();
            }
        });
        return super.setBinding(variableId, vo);
    }
}
