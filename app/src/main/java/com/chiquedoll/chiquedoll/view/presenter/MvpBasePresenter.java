package com.chiquedoll.chiquedoll.view.presenter;

import com.chiquedoll.chiquedoll.view.mvpview.MvpView;

import java.lang.ref.WeakReference;

/**
 * Created by super-zuo on 17-3-2.
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;

    @Override
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef!=null){
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
