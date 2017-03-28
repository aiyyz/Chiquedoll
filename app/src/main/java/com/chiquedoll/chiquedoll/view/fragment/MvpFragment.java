package com.chiquedoll.chiquedoll.view.fragment;

import android.os.Bundle;

import com.chiquedoll.chiquedoll.view.mvpview.MvpView;
import com.chiquedoll.chiquedoll.view.presenter.MvpPresenter;

/**
 * Created by super-zuo on 17-3-21.
 */

public abstract class MvpFragment<V extends MvpView,P extends MvpPresenter<V>>extends BaseFragment {

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().attachView((V) this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().detachView(isRetainingInstance());
        getPresenter().destroy();
    }



    public abstract P getPresenter();

    public boolean isRetainingInstance() {
        return false;
    }

}
