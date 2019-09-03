package com.coder.zzq.toolkit.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.coder.zzq.toolkit.Utils;
import com.coder.zzq.toolkit.log.EasyLogger;

/**
 * Created by 朱志强 on 2018/08/19.
 */
public class ActivityCallback implements Application.ActivityLifecycleCallbacks {
    private int mVisibleCounter = 0;
    private Activity mLastVisibleActivity;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        EasyLogger.d("activity created:" + Utils.getActivityInfo(activity));
        ActivityStack.push(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        EasyLogger.d("activity started:" + Utils.getActivityInfo(activity));
        if (mVisibleCounter == 0) {
            onAppForeground(mLastVisibleActivity == null);
        }
        mVisibleCounter++;
        mLastVisibleActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        EasyLogger.d("activity resumed:" + Utils.getActivityInfo(activity));
    }

    @Override
    public void onActivityPaused(Activity activity) {
        EasyLogger.d("activity paused:" + Utils.getActivityInfo(activity));
    }

    @Override
    public void onActivityStopped(Activity activity) {
        EasyLogger.d("activity stopped:" + Utils.getActivityInfo(activity));

        mVisibleCounter--;

        if (mVisibleCounter == 0) {
            onAppBackground(ActivityStack.count() == 1 && activity.isFinishing());
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        EasyLogger.d("activity saveState:" + Utils.getActivityInfo(activity));
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        EasyLogger.d("activity destroyed:" + Utils.getActivityInfo(activity));
        ActivityStack.pop(activity);
        if (activity == mLastVisibleActivity) {
            mLastVisibleActivity = null;
        }

        EasyLogger.d("the activity stack size:" + ActivityStack.count());
    }

    public void onAppForeground(boolean restartMainActivity) {
        EasyLogger.d("App foreground");
    }

    public void onAppBackground(boolean activityStackEmpty) {
        EasyLogger.d("App background");
    }


}
