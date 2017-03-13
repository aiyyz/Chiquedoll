package com.chiquedoll.chiquedoll.view;

import android.app.Application;

import com.chiquedoll.chiquedoll.BuildConfig;
import com.chiquedoll.chiquedoll.internal.dl.components.ApplicationComponent;
import com.chiquedoll.chiquedoll.internal.dl.components.DaggerApplicationComponent;
import com.chiquedoll.chiquedoll.internal.dl.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by super-zuo on 17-2-22.
 */

public class BaseApplication extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        initializeLeakDetection();
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
