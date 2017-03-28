package com.chiquedoll.chiquedoll.internal.dl.components;

import android.content.Context;

import com.chiquedoll.chiquedoll.internal.dl.modules.ApiModule;
import com.chiquedoll.chiquedoll.internal.dl.modules.ApplicationModule;
import com.chiquedoll.chiquedoll.view.activity.BaseActivity;
import com.chquedoll.domain.executor.PostExecutionThread;
import com.chquedoll.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by super-zuo on 17-2-22.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

}
