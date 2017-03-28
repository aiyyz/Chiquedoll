package com.chiquedoll.chiquedoll.view.presenter;

import com.chiquedoll.chiquedoll.view.mvpview.ProductDetailView;
import com.chquedoll.domain.entity.ProductCommentEntity;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.interactor.DefaultObserver;
import com.chquedoll.domain.interactor.GetProductDetails;

import javax.inject.Inject;

/**
 * Created by super-zuo on 17-3-20.
 */

public class ProductDetailPresenter extends MvpBasePresenter<ProductDetailView> {

    private final GetProductDetails getProductDetails;
    private String productId;

    @Inject
    public ProductDetailPresenter(GetProductDetails getProductDetails) {
        this.getProductDetails = getProductDetails;
    }

    @Override
    public void initialize() {
        productId = getView().getProductId();
        getProductData();
    }

    private void getProductData() {
        getView().showLoading();
        getProductDetails.execute(new ProductDetailSubscriber(), GetProductDetails.Params.forProduct(productId, null));
    }

    private class ProductDetailSubscriber extends DefaultObserver {
        @Override
        protected void onStart() {
            super.onStart();
        }

        @Override
        public void onNext(Object o) {
            super.onNext(o);
            if (o instanceof ProductDetailEntity) {

            } else if (o instanceof ProductCommentEntity) {

            }
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);

        }
    }
}
