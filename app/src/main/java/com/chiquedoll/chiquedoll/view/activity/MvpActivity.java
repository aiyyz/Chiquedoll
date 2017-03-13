package com.chiquedoll.chiquedoll.view.activity;

import android.content.Context;
import android.os.Bundle;

import com.chiquedoll.chiquedoll.view.MvpView;
import com.chiquedoll.chiquedoll.view.presenter.MvpPresenter;

/**
 * Created by super-zuo on 17-3-2.
 */

public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends BaseActivity implements MvpView {

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().attachView((V) this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView(isRetainingInstance());
        getPresenter().destroy();
    }

    @Override
    public Context context() {
        return getApplicationContext();
    }

    public abstract P getPresenter();

    public boolean isRetainingInstance() {
        return false;
    }

}
