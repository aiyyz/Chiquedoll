package com.chiquedoll.chiquedoll.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chiquedoll.chiquedoll.R;
import com.chiquedoll.chiquedoll.internal.dl.components.ProductDetailComponent;
import com.chiquedoll.chiquedoll.view.mvpview.ProductDetailView;
import com.chiquedoll.chiquedoll.view.presenter.ProductDetailPresenter;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

/**
 * Created by super-zuo on 17-3-21.
 * Description:
 */

public class ProductDetailFragment extends MvpFragment<ProductDetailView, ProductDetailPresenter> implements ProductDetailView {

    @Inject
    ProductDetailPresenter productDetailPresenter;

    public ProductDetailFragment() {
        setRetainInstance(true);
    }

    public static ProductDetailFragment forProduct(String productId){
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("productId",productId);
        productDetailFragment.setArguments(bundle);
        return productDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ProductDetailComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container,false);
        Button bt_loading = (Button) view.findViewById(R.id.bt_loading);
        bt_loading.setOnClickListener(v -> productDetailPresenter.initialize());
        return view;
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
        Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments,"Fragment argument can't be null");
        return arguments.getString("productId");
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
