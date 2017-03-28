package com.chquedoll.domain.repository;


import com.chquedoll.domain.entity.ProductCommentEntity;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.entity.ProductEntity;
import com.chquedoll.domain.module.BaseResponse;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-3-20.
 */

public interface ProductRepository {

    Observable<BaseResponse<ProductDetailEntity>> productDetail(String productId, Integer index);

    Observable<BaseResponse<ProductCommentEntity>> productComment(String productId);

    Observable<BaseResponse<ArrayList<ProductEntity>>> relatedProduct(String productId,int skip,int limit);
}
