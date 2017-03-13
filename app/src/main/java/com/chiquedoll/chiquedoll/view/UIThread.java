package com.chiquedoll.chiquedoll.view;

import com.chquedoll.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by super-zuo on 17-2-22.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
