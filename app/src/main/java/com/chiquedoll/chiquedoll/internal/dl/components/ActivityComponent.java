package com.chiquedoll.chiquedoll.internal.dl.components;

import android.app.Activity;

import com.chiquedoll.chiquedoll.internal.dl.PerActivity;
import com.chiquedoll.chiquedoll.internal.dl.modules.ActivityModule;

import dagger.Component;

/**
 * Created by super-zuo on 17-3-2.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent  {
    Activity activity();
}
