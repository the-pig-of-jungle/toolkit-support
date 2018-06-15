package com.coder.zzq.toolkit.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 小朱先森 on 2018/5/7.
 */

public class ViewCaster {
    private View mView;

    public ViewCaster() {

    }

    public ViewCaster setView(View view) {
        mView = view;
        return this;
    }

    public <T> T toView(Class<T> viewType){
        return viewType.cast(mView);
    }

    public TextView toTextView(){
        return (TextView) mView;
    }

    public ImageView toImgView(){
        return (ImageView) mView;
    }

    public View plainView() {
        return mView;
    }
}
