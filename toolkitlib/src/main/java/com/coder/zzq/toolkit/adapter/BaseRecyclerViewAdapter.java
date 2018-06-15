package com.coder.zzq.toolkit.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate()
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
