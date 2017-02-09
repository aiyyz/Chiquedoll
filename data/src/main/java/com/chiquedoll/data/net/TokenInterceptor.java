package com.chiquedoll.data.net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by super-zuo on 17-2-9.
 */

public class TokenInterceptor implements Interceptor {

    private final Context context;

    public TokenInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if (response.code() == 600){
            String newToken = refreshToken();
            Request newRequest = request
                    .newBuilder()
                    .header("accessToken",newToken)
                    .build();
            return chain.proceed(newRequest);
        }
        return response;
    }

    private String refreshToken() {
        // TODO: 17-2-9 refresh token
        return null;
    }
}
