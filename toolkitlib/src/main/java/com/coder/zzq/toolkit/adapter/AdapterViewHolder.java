package com.coder.zzq.toolkit.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.coder.zzq.toolkit.R;
import com.coder.zzq.toolkit.widget.IViewHolder;
import com.coder.zzq.toolkit.widget.PlainViewHolder;

public class AdapterViewHolder extends RecyclerView.ViewHolder implements IViewHolder{
    private PlainViewHolder mPlainViewHolder;
    public AdapterViewHolder(View itemView) {
        super(itemView);
        mPlainViewHolder = new PlainViewHolder(itemView);
    }

    @Override
    public Context getContext() {
        return mPlainViewHolder.getContext();
    }

    @Override
    public ViewCaster getRootView() {
        return mPlainViewHolder.getRootView();
    }

    @Override
    public View getRootViewAsPlain() {
        return mPlainViewHolder.getRootViewAsPlain();
    }

    @Override
    public ViewCaster getView(int idRes) {
        return mPlainViewHolder.getView(idRes);
    }

    @Override
    public View getViewAsPlain(int idRes) {
        return mPlainViewHolder.getViewAsPlain(idRes);
    }

    @Override
    public IViewHolder setVisibility(int viewId, int visibility) {
        return mPlainViewHolder.setVisibility(viewId,visibility);
    }

    @Override
    public IViewHolder setText(int viewId, CharSequence text) {
        return mPlainViewHolder.setText(viewId,text);
    }

    @Override
    public IViewHolder setText(int viewId, int text) {
        return mPlainViewHolder.setText(viewId,text);
    }

    @Override
    public IViewHolder setTextColor(int viewId, int color) {
        return mPlainViewHolder.setTextColor(viewId,color);
    }

    @Override
    public IViewHolder setTextColorRes(int viewId, int colorRes) {
        return mPlainViewHolder.setTextColorRes(viewId,colorRes);
    }

    @Override
    public IViewHolder setImg(int viewId, Drawable drawable) {
        return mPlainViewHolder.setImg(viewId, drawable);
    }

    @Override
    public IViewHolder setImg(int viewId, int drawableRes) {
        return mPlainViewHolder.setImg(viewId,drawableRes);
    }

    @Override
    public IViewHolder setImg(int viewId, Bitmap bitmap) {
        return mPlainViewHolder.setImg(viewId,bitmap);
    }
}
