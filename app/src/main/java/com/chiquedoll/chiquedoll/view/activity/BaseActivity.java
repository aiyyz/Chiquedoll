package com.chiquedoll.chiquedoll.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.chiquedoll.chiquedoll.internal.dl.components.ApplicationComponent;
import com.chiquedoll.chiquedoll.internal.dl.modules.ActivityModule;
import com.chiquedoll.chiquedoll.view.BaseApplication;
import com.chiquedoll.chiquedoll.view.LoadDataView;

/**
 * Created by super-zuo on 17-3-2.
 */

public class BaseActivity extends AppCompatActivity implements LoadDataView{
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
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }
}
