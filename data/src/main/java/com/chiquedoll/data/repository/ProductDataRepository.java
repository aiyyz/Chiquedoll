package com.chiquedoll.data.repository;

import android.content.Context;

import com.chiquedoll.data.net.Api.ProductApi;
import com.chiquedoll.data.net.ApiConnection;
import com.chquedoll.domain.entity.ProductCommentEntity;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.entity.ProductEntity;
import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.repository.ProductRepository;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-3-23.
 */
public class ProductDataRepository implements ProductRepository {


    ProductApi productApi;


    @Inject
    public ProductDataRepository(Context context) {
        productApi = ApiConnection.getInstance(context).createApi(ProductApi.class);
    }

    @Override
    public Observable<BaseResponse<ProductDetailEntity>> productDetail(String productId, Integer index) {

        return productApi.productDetail(productId, index);
    }

    @Override
    public Observable<BaseResponse<ProductCommentEntity>> productComment(String productId) {
        return productApi.productComment(productId);
    }

    @Override
    public Observable<BaseResponse<ArrayList<ProductEntity>>> relatedProduct(String productId, int skip, int limit) {
        return productApi.relatedProduct(skip,limit,productId);
    }
}
