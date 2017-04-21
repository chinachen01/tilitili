package com.focus.tilitili.app;

import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.focus.tilitili.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

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
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        //init logger
        Logger.init(TAG)
                .logLevel(BuildConfig.DEBUG
                        ? LogLevel.FULL
                        : LogLevel.NONE); // default LogLevel.FULL
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

    public static App getInstance() {
        return sInstance;
    }
}
