package com.coder.zzq.toolkit.log;

import android.util.Log;

import com.coder.zzq.toolkit.Toolkit;

public class EasyLogger {

    public static void d(String msg) {
        if (Toolkit.isEnablePrintLog()) {
            Log.d(Toolkit.getLogTag(), msg);
        }
    }

    public static void e(String error) {
        if (Toolkit.isEnablePrintLog()) {
            Log.e(Toolkit.getLogTag(), error);
        }
    }
}
