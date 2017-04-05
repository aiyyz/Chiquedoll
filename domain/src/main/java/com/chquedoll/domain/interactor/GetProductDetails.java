package com.chquedoll.domain.interactor;

import com.chquedoll.domain.entity.ProductCommentEntity;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.executor.PostExecutionThread;
import com.chquedoll.domain.executor.ThreadExecutor;
import com.chquedoll.domain.repository.ProductRepository;
import com.google.common.base.Preconditions;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-3-21.
 */

public class GetProductDetails extends UseCase<Object, GetProductDetails.Params> {

    private final ProductRepository productRepository;

    @Inject
    GetProductDetails(ProductRepository productRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.productRepository = productRepository;
    }

    @Override
    Observable<Object> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params, "The params can not be null!");
        Observable<ProductDetailEntity> productDetailEntityObservable = productRepository.productDetail(params.productId, params.index).map(new ResponseFilter<>());
        Observable<ProductCommentEntity> productCommentEntityObservable = productRepository.productComment(params.productId).map(new ResponseFilter<>());
        return Observable.mergeDelayError(productDetailEntityObservable, productCommentEntityObservable);

    }


    public static class Params {

        private final String productId;
        private final Integer index;

        private Params(String productId, Integer index) {
            this.productId = productId;
            this.index = index;
        }

        public static Params forProduct(String productId, Integer index) {
            return new Params(productId, index);
        }
    }
}
