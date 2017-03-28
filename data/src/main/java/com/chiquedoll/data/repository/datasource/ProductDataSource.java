package com.chiquedoll.data.repository.datasource;

import com.chiquedoll.data.BuildConfig;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.module.BaseResponse;

import io.reactivex.SingleObserver;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by super-zuo on 17-3-17.
 */

public interface ProductDataSource {

    @GET(BuildConfig.INTERFACE_VERSION+"product/anon/{productId}/show")
    SingleObserver<BaseResponse<ProductDetailEntity>> productDetail(@Path("productId") String  productId, @Query("recommendIndex") Integer recommendIndex);

}
