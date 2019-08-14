package com.coder.zzq.toolkit.demo;

import android.app.Application;
import android.widget.Toast;

import com.coder.zzq.toolkit.Toolkit;
import com.coder.zzq.toolkit.lifecycle.ActivityCallback;
import com.coder.zzq.toolkit.log.EasyLogger;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Toolkit.init(this);
        Toolkit.setEnablePrintLog(true);
        registerActivityLifecycleCallbacks(new ActivityCallback() {
            @Override
            public void onAppForeground(boolean restartMainActivity) {
                super.onAppForeground(restartMainActivity);
                if (!restartMainActivity) {
                    Toast.makeText(MyApplication.this, "位于前台", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAppBackground(boolean activityStackEmpty) {
                super.onAppBackground(activityStackEmpty);
                if (!activityStackEmpty) {
                    Toast.makeText(MyApplication.this, "位于后台", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
