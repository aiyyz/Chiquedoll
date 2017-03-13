package com.chiquedoll.chiquedoll.internal.dl.modules;

import android.app.Activity;

import com.chiquedoll.chiquedoll.internal.dl.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by super-zuo on 17-2-22.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return mActivity;
    }
}
