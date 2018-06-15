package com.coder.zzq.toolkit.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.coder.zzq.toolkit.adapter.ViewCaster;

public interface IViewHolder {

    Context getContext();

    ViewCaster getRootView();

    View getRootViewAsPlain();

    ViewCaster getView(@IdRes int idRes);

    View getViewAsPlain(@IdRes int idRes);

    IViewHolder setVisibility(@IdRes int viewId, int visibility);

    IViewHolder setText(@IdRes int viewId, CharSequence text);

    IViewHolder setText(@IdRes int viewId, @StringRes int text);

    IViewHolder setTextColor(@IdRes int viewId, @ColorInt int color);

    IViewHolder setTextColorRes(@IdRes int viewId, @ColorRes int colorRes);

    IViewHolder setImg(@IdRes int viewId, Drawable drawable);

    IViewHolder setImg(@IdRes int viewId, @DrawableRes int drawableRes);

    IViewHolder setImg(@IdRes int viewId, Bitmap bitmap);


}
