package com.chiquedoll.chiquedoll.internal.dl.modules;

import android.content.Context;

import com.chiquedoll.chiquedoll.view.BaseApplication;
import com.chiquedoll.chiquedoll.view.UIThread;
import com.chiquedoll.data.executor.JobExecutor;
import com.chquedoll.domain.executor.PostExecutionThread;
import com.chquedoll.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final BaseApplication baseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.baseApplication;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecution(UIThread uiThread) {
        return uiThread;
    }
}
