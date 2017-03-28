package com.chiquedoll.data.net.Api;

import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.module.LoginInResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by super-zuo on 17-2-24.
 */

public interface RestApi {

    @FormUrlEncoded
    @POST
    Observable<BaseResponse<LoginInResponse>> login(@Url String url, @Field("email") String email, @Field("password") String password);

    @GET
    Call<String> getMessage(@Url String url);
}
