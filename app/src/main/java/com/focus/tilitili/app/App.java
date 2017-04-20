package com.focus.tilitili.app;

import android.support.multidex.MultiDexApplication;

import com.focus.tilitili.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by focus on 17/4/19.
 */

public class App extends MultiDexApplication {
    private static final String TAG = "tilitili";
    private static App sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initLib();
    }

    private void initLib() {
        //init logger
        Logger.init(TAG)
                .logLevel(BuildConfig.DEBUG
                        ? LogLevel.FULL
                        : LogLevel.NONE); // default LogLevel.FULL
    }

    public static App getInstance() {
        return sInstance;
    }
}
