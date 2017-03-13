package com.chiquedoll.chiquedoll.view.presenter;

import com.chiquedoll.chiquedoll.view.MvpView;

/**
 * Created by super-zuo on 17-3-2.
 */

public interface MvpPresenter<V extends MvpView> {

    V getView();

    void attachView(V view);

    void detachView(boolean retainInstance);

    void initialize();

    void resume();

    void pause();

    void destroy();
}
