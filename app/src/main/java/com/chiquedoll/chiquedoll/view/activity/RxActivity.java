package com.chiquedoll.chiquedoll.view.activity;

import com.chquedoll.domain.interactor.ResponseFilter;
import com.chquedoll.domain.module.BaseResponse;
import com.google.common.base.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by super-zuo on 17-3-15.
 */

public class RxActivity<T> extends BaseActivity {
    private final CompositeDisposable disposables = new CompositeDisposable();


    public void execute(DisposableObserver<T> observer, Observable<BaseResponse<T>> observable) {
        Preconditions.checkNotNull(observable);
        Preconditions.checkNotNull(observer);
        DisposableObserver disposableObserver = observable
                .map(new ResponseFilter<>())
                .subscribeOn(Schedulers.from(getApplicationComponent().threadExecutor()))
                .observeOn(getApplicationComponent().postExecutionThread().getScheduler())
                .subscribeWith(observer);
        addDisposable(disposableObserver);
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        dispose();
    }
}
