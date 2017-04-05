package com.chiquedoll.data.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.chiquedoll.data.utils.DeviceUtils;

import java.io.IOException;
import java.util.List;
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

    public static void setAccessToken(String accessToken) {
        HeadInterceptor.accessToken = accessToken;
    }

    private static String accessToken = "";
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
            List<String> pathSegments = original.url().pathSegments();
            if (pathSegments != null && pathSegments.size() > 2) {
                userIdBuilder.setPathSegment(0, "L")
                        .setPathSegment(1, userId);
                for (int i = 0; i < pathSegments.size() - 2; i++) {
                    userIdBuilder.setPathSegment(2 + i, pathSegments.get(i));
                }
                userIdBuilder.addPathSegment(pathSegments.get(pathSegments.size() - 2));
                userIdBuilder.addPathSegment(pathSegments.get(pathSegments.size() - 1));
            } else if (pathSegments != null && pathSegments.size() == 1) {
                userIdBuilder.setPathSegment(0, "L")
                        .setPathSegment(1, userId)
                        .addPathSegment(pathSegments.get(0));
            } else {
                userIdBuilder.setPathSegment(0, "L")
                        .setPathSegment(1, userId);
            }

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
        if (!TextUtils.isEmpty(accessToken)) {
            builder.header("accessToken", accessToken);
        }
        if (userIdBuilder != null) {
            builder.url(userIdBuilder.build());
        }
        return chain.proceed(builder.build());
    }

    private String getUniqueId() {
        return DeviceUtils.getUniqueId(context);
    }

    private String getVersionName() {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
