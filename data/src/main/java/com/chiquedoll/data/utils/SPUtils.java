package com.chiquedoll.data.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

/**
 * Created by super-zuo on 17-2-10.
 */
@Singleton
public class SPUtils {

    public static String USER_NAME = "username";
    public static String USER_PASSWORD = "password";
    public static String USER_INFO_SP = "user_info";

    public static void saveInfo(Context context, String spName, String key, Object value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(spName, Context.MODE_PRIVATE).edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (int) value);
        }
        editor.apply();
    }

    public static void saveUserInfo(Context context, String username, String password) {

        try {
            String desName = DesUtil.decryptDES(username);
            String desPassword = DesUtil.decryptDES(password);
            saveInfo(context, USER_INFO_SP, USER_NAME, desName);
            saveInfo(context, USER_INFO_SP, USER_PASSWORD, desPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUserName(Context context) {
        String desUser = getStringInfo(context, USER_INFO_SP, USER_NAME);
        try {
            return DesUtil.encryptDES(desUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getUserPassword(Context context) {
        String desPassword = getStringInfo(context, USER_INFO_SP, USER_PASSWORD);
        try {
            return DesUtil.encryptDES(desPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getStringInfo(Context context, String spName, String key) {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE).getString(key, "");
    }

    public static boolean getBooleanInfo(Context context, String spName, String key) {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE).getBoolean(key, false);
    }

    public static int getIntInfo(Context context, String spName, String key) {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE).getInt(key, -1);
    }
}
