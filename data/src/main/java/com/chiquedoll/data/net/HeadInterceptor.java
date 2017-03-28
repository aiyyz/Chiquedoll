package com.chiquedoll.data.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static dagger.internal.Preconditions.checkNotNull;


/**
 * Created by super-zuo on 17-2-9.
 */

public class HeadInterceptor implements Interceptor {

    private static String acceptLanguage = Locale.getDefault().getLanguage();
    private static String countryCode = Locale.getDefault().getCountry();
    private static String userId = "";
    private final Context context;

    public static void setAcceptLanguage(String acceptLanguage) {
        HeadInterceptor.acceptLanguage = acceptLanguage;
    }

    public static void setCountryCode(String countryCode) {
        HeadInterceptor.countryCode = countryCode;
    }

    public static void setUserId(String userId) {
        HeadInterceptor.userId = userId;
    }


    public HeadInterceptor(@NonNull Context context) {
        this.context = checkNotNull(context, "Context cannot be null");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl.Builder userIdBuilder = null;
        if (!TextUtils.isEmpty(userId)) {
            userIdBuilder = original.url().newBuilder();
            userIdBuilder
                    .host(original.url().host() + "/L/" + userId)
                    .scheme(original.url().scheme());
        }
        Request.Builder builder = original.newBuilder();
        builder.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .header("accept-language", acceptLanguage)
                .header("appVersion", getVersionName())
                .header("countryCode", countryCode)
                .header("deviceSystemVersion", Build.VERSION.RELEASE)
                .header("deviceType", "android")
                .header("deviceId", getUniqueId())
                .header("Accept-Encoding", "gzip,deflate");
        if (userIdBuilder != null) {
            builder.url(userIdBuilder.build());
        }
        return chain.proceed(builder.build());
    }

    private String getUniqueId() {
        // TODO: 17-2-9 wid
        return 123 + "";
    }

    private String getVersionName() {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
