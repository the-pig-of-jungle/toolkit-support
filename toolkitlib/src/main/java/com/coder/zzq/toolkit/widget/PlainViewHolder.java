package com.coder.zzq.toolkit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.View;


import com.coder.zzq.toolkit.adapter.ViewCaster;
import com.coder.zzq.toolkit.widget.IViewHolder;

public class PlainViewHolder implements IViewHolder {

    private View mRootView;
    private SparseArray<View> mIdToView;
    private ViewCaster mViewCaster;

    public PlainViewHolder(View rootView) {
        mRootView = rootView;
        mIdToView = new SparseArray<>();
        mViewCaster = new ViewCaster();
    }


    private View findView(@IdRes int viewId) {
        View view = mIdToView.get(viewId, null);
        if (view == null) {
            view = mRootView.findViewById(viewId);
            mIdToView.put(viewId, view);
        }

        return view;

    }

    private <T> T findView(@IdRes int viewId, Class<T> viewClass) {
        return viewClass.cast(findView(viewId));
    }

    @Override
    public Context getContext() {
        return mRootView.getContext();
    }

    @Override
    public ViewCaster getRootView() {
        mViewCaster.setView(mRootView);
        return mViewCaster;
    }

    @Override
    public View getRootViewAsPlain() {
        return mRootView;
    }

    @Override
    public ViewCaster getView(int idRes) {
        mViewCaster.setView(findView(idRes));
        return mViewCaster;
    }

    @Override
    public View getViewAsPlain(int idRes) {
        return findView(idRes);
    }

    @Override
    public IViewHolder setVisibility(int viewId, int visibility) {
        findView(viewId).setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public IViewHolder setText(@IdRes int viewId, CharSequence text) {
        mViewCaster.setView(findView(viewId)).toTextView().setText(text);
        return this;
    }

    @Override
    public IViewHolder setText(@IdRes int viewId, @StringRes int text) {
        mViewCaster.setView(findView(viewId)).toTextView().setText(text);
        return this;
    }

    @Override
    public IViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        mViewCaster.setView(findView(viewId)).toTextView().setTextColor(color);
        return this;
    }

    @Override
    public IViewHolder setTextColorRes(@IdRes int viewId, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(getContext(),colorRes);
        setTextColor(viewId,color);
        return this;
    }

    @Override
    public IViewHolder setImg(int viewId, Drawable drawable) {
        mViewCaster.setView(findView(viewId)).toImgView().setImageDrawable(drawable);
        return this;
    }

    @Override
    public IViewHolder setImg(@IdRes int viewId, @DrawableRes int drawableRes) {
        mViewCaster.setView(findView(viewId)).toImgView().setImageResource(drawableRes);
        return this;
    }

    @Override
    public IViewHolder setImg(@IdRes int viewId, Bitmap bitmap) {
        mViewCaster.setView(findView(viewId)).toImgView().setImageBitmap(bitmap);
        return this;
    }

}
