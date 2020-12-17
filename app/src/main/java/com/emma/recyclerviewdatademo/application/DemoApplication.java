package com.emma.recyclerviewdatademo.application;

import android.app.Application;

import com.emma.recyclerviewdatademo.BuildConfig;

import timber.log.Timber;

public class DemoApplication extends Application {
    private static DemoApplication initApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication = this;

        //啟用timber
        Timber.plant(new Timber.DebugTree());
    }
}
