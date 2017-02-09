package com.chiquedoll.data.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by super-zuo on 17-2-9.
 */

public class HeadInterceptor implements Interceptor {
    private static String acceptLanguage = Locale.getDefault().getLanguage();
    private static String countryCode = Locale.getDefault().getCountry();
    private final Context context;

    public HeadInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder builder = original.newBuilder();
        builder.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .header("accept-language", acceptLanguage)
                .header("appVersion", getVersionName())
                .header("countryCode", countryCode)
                .header("deviceSystemVersion", Build.VERSION.RELEASE)
                .header("deviceType", "android")
                .header("deviceId", getUniqueId())
                .header("Accept-Encoding", "gzip,deflate");

        return null;
    }

    private String getUniqueId() {
        // TODO: 17-2-9 wid
        return null;
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
