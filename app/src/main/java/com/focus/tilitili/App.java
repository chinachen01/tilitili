package com.focus.tilitili;

import android.support.multidex.MultiDexApplication;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by focus on 17/4/19.
 */

public class App extends MultiDexApplication {
    private static final String TAG = "tilitili";
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.NONE)        // default LogLevel.FULL
                .methodOffset(2);               // default 0
    }
}
