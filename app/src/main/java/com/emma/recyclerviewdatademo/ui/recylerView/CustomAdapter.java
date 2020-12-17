package com.emma.recyclerviewdatademo.ui.recylerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public abstract class CustomAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<T> dataSet;
    private int layoutId;
    protected int variableId;

    public CustomAdapter(List<T> dataSet, int layoutId, int variableId) {
        this.dataSet = dataSet;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding viewDataBinding = DataBindingUtil.bind(LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false));
        return viewHolder(viewDataBinding);
    }

    public abstract RecyclerView.ViewHolder viewHolder(ViewDataBinding viewDataBinding);

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        convertViewHolder(viewHolder,dataSet.get(i));
        viewHolder.setIsRecyclable(false);  //add 修fragment
        viewHolder.itemView.setTag(i);
    }


    public abstract void convertViewHolder(RecyclerView.ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return dataSet==null?0:dataSet.size();
    }

    public void remove(int position) {
        Timber.d("remove(int position) = "+position);
        if (position >= 0 && position < dataSet.size()) {
            dataSet.remove(position);
            notifyItemRemoved(position);
            //刷新下标，不然下标就重复
            notifyItemRangeRemoved(position,dataSet.size());
        }
    }

    public void refreshData(ArrayList<T> newDataSet){
        this.dataSet = newDataSet;
//        for (int i=0;i<newDataSet.size();i++){
//            Timber.d("newDataSet ~~~~ newDataSet("+i+") = "+gson.toJson(newDataSet.get(i)));
//        }
        notifyDataSetChanged();
    }

    public void setDatas(List<T> mDatas) {
        this.dataSet = mDatas;
    }

}

