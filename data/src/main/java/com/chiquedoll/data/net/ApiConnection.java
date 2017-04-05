package com.chiquedoll.data.net;

import android.content.Context;
import android.support.annotation.NonNull;


import com.chiquedoll.data.BuildConfig;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by super-zuo on 17-2-21.
 */
public class ApiConnection {

    private Retrofit mRetrofit;
    private static ApiConnection mInstance;
    private static ApiConnection mNoRxjavaInstance;
    private final static String baseUrl = "http://www.chicme.xyz";
//    private final static String baseUrl = "http://www.chicme.com";

    private ApiConnection(Context context) {
        this(context, true);
    }

    public static ApiConnection getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ApiConnection.class) {
                if (mInstance == null) {
                    mInstance = new ApiConnection(context);
                }
            }
        }
        return mInstance;
    }

    public static ApiConnection getNoRxjavaInstance(Context context) {
        if (mNoRxjavaInstance == null) {
            synchronized (ApiConnection.class) {
                if (mNoRxjavaInstance == null) {
                    mNoRxjavaInstance = new ApiConnection(context, false);
                }
            }
        }
        return mNoRxjavaInstance;
    }

    private ApiConnection(Context context, boolean useRxJava) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(context));
        if (useRxJava) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        }
        mRetrofit = builder.build();
    }

    public <T> T createApi(Class<T> clazz){
        return mRetrofit.create(clazz);
    }

    @NonNull
    private OkHttpClient getClient(Context context) {
        // log用拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        // 如果使用到HTTPS，我们需要创建SSLSocketFactory，并设置到client
        javax.net.ssl.SSLSocketFactory sslSocketFactory = null;

        try {
            // 这里直接创建一个不做证书串验证的TrustManager
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {
        }

        return new OkHttpClient.Builder()
                // HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
                .addInterceptor(new HeadInterceptor(context))
                .addInterceptor(logging)
                .addInterceptor(new TokenInterceptor(context))
                // 连接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                // 读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                .sslSocketFactory(sslSocketFactory)
                // 信任所有主机名
                .hostnameVerifier((hostname, session) -> true)
                // 这里我们使用host name作为cookie保存的key
                .cookieJar(new CookieJar() {
                    private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(HttpUrl.parse(url.host()), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(HttpUrl.parse(url.host()));
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
    }

}
