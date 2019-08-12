package com.coder.zzq.toolkit.log;

import android.util.Log;

import com.coder.zzq.toolkit.Utils;

public class EasyLogger {
    public static final String DEFAULT_LOG_TAG = "easy-logger";
    private static String sLogTag = DEFAULT_LOG_TAG;
    private static boolean sPrintLog = false;

    public static void setLogTag(String tag) {
        sLogTag = Utils.isEmpty(tag) ? DEFAULT_LOG_TAG : tag;
    }


    public static void setPrintLog(boolean printLog) {
        sPrintLog = printLog;
    }


    public static void d(String msg) {
        if (sPrintLog) {
            Log.d(sLogTag, msg);
        }
    }

    public static void e(String error) {
        if (sPrintLog) {
            Log.e(sLogTag, error);
        }
    }
}
