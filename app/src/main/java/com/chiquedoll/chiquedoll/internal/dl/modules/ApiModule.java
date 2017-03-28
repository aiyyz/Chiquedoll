package com.chiquedoll.chiquedoll.internal.dl.modules;

import android.content.Context;

import com.chiquedoll.data.net.Api.ProductApi;
import com.chiquedoll.data.net.ApiConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by super-zuo on 17-3-23.
 */
@Module
public class ApiModule {

    private final Context context;

    public ApiModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    ProductApi getProductApi() {
        return createApi(ProductApi.class);
    }

    private <T> T createApi(Class<T> clazz) {
        return ApiConnection.getInstance(context).createApi(clazz);
    }
}
