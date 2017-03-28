package com.chiquedoll.data.net.Api;

import com.chiquedoll.data.BuildConfig;
import com.chquedoll.domain.entity.ProductCommentEntity;
import com.chquedoll.domain.entity.ProductDetailEntity;
import com.chquedoll.domain.entity.ProductEntity;
import com.chquedoll.domain.module.BaseResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by super-zuo on 17-3-23.
 */

public interface ProductApi {

    @GET(BuildConfig.INTERFACE_VERSION + "product/anon/{productId}/show")
    Observable<BaseResponse<ProductDetailEntity>> productDetail(@Path("productId") String productId, @Query("recommendIndex") Integer recommendIndex);

    @GET(BuildConfig.INTERFACE_VERSION + "product/anon/{productId}/get-product-comment")
    Observable<BaseResponse<ProductCommentEntity>> productComment(@Path("productId") String productId);

    @GET(BuildConfig.INTERFACE_VERSION + "product/{skip}/{limit}/{productId}/scp/show")
    Observable<BaseResponse<ArrayList<ProductEntity>>>  relatedProduct(@Path("skip") int skip,@Path("limit") int limit,@Path("productId") String productId);
}
