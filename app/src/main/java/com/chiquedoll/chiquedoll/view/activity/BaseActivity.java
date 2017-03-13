package com.chiquedoll.chiquedoll.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chiquedoll.chiquedoll.internal.dl.components.ApplicationComponent;
import com.chiquedoll.chiquedoll.internal.dl.modules.ActivityModule;
import com.chiquedoll.chiquedoll.view.BaseApplication;
import com.chiquedoll.data.net.HeadInterceptor;

import java.util.stream.Stream;

/**
 * Created by super-zuo on 17-3-2.
 */

public class BaseActivity extends AppCompatActivity {
    private ActivityModule activityModule;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        if (activityModule == null) {
            return new ActivityModule(this);
        }
        return activityModule;
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}
