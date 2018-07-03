package com.coder.zzq.toolkit.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<DataItem> extends RecyclerView.Adapter<AdapterViewHolder> {

    private List<DataItem> mData;

    public BaseRecyclerViewAdapter() {
        mData = new ArrayList<>();
    }

    @LayoutRes
    protected abstract int itemLayoutRes();


    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayoutRes(), parent, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(itemView);
        afterViewHolderCreated(adapterViewHolder);
        return adapterViewHolder;
    }

    protected void afterViewHolderCreated(AdapterViewHolder adapterViewHolder){

    }


    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        DataItem dataItem = mData.get(position);
        bindDataToItem(holder, dataItem, position);
    }

    protected abstract void bindDataToItem(AdapterViewHolder holder, DataItem dataItem, int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<DataItem> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    public void appendData(DataItem dataItem) {
        int insertedPos = mData.size();
        mData.add(dataItem);
        notifyItemInserted(insertedPos);
    }

    public void appendData(List<DataItem> dataItems){
        mData.addAll(dataItems);
        notifyDataSetChanged();
    }


    public void appendData(DataItem[] dataItems){
        List<DataItem> list = Arrays.asList(dataItems);
        appendData(list);
    }




}
