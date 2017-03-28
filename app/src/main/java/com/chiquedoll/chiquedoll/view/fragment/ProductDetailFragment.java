package com.chiquedoll.chiquedoll.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chiquedoll.chiquedoll.internal.dl.components.ProductDetailComponent;
import com.chiquedoll.chiquedoll.view.activity.ProductDetailActivity;
import com.chiquedoll.chiquedoll.view.mvpview.ProductDetailView;
import com.chiquedoll.chiquedoll.view.presenter.ProductDetailPresenter;

import javax.inject.Inject;

/**
 * Created by super-zuo on 17-3-21.
 */

public class ProductDetailFragment extends MvpFragment<ProductDetailView, ProductDetailPresenter> implements ProductDetailView {

    @Inject
    ProductDetailPresenter productDetailPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ProductDetailComponent.class).inject(this);

    }

    @Override
    public ProductDetailPresenter getPresenter() {
        return productDetailPresenter;
    }

    @Override
    public void productDetail() {

    }

    @Override
    public void relativeProduct() {

    }

    @Override
    public String getProductId() {
        return null;
    }

    @Override
    public Context context() {
        return getActivity();
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
