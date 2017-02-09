package com.chiquedoll.data.net;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by super-zuo on 17-2-9.
 */
@Component(modules = {NetConnectionModule.class})
public interface NetComponent {
    Retrofit getRetrofit();
}
