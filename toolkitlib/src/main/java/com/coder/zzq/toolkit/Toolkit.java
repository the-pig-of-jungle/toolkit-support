package com.coder.zzq.toolkit;

import android.app.Application;

public class Toolkit {
    private static Application sContext;

    public static final String DEFAULT_LOG_TAG = "easy-logger";

    private static boolean sEnablePrintLog;

    private static String sLogTag = DEFAULT_LOG_TAG;

    public static void init(Application application) {
        sContext = Utils.requireNonNull(application, "application can not null!");
    }


    public static Application getContext() {
        return Utils.requireNonNull(sContext, "you have not init Toolkit by invoke method : init(application)");
    }


    public static boolean isEnablePrintLog() {
        return sEnablePrintLog;
    }


    public static void setEnablePrintLog(boolean enablePrintLog) {
        sEnablePrintLog = enablePrintLog;
    }


    public static void setLogTag(String tag) {
        sLogTag = Utils.isEmpty(tag) ? DEFAULT_LOG_TAG : tag;
    }

    public static String getLogTag() {
        return sLogTag;
    }
}
