package com.chiquedoll.data.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhangsk on 2015/7/10.
 */
public class DeviceUtils {
    /**
     * 判断是否为平板
     *
     * @return
     */
    public static boolean isPad(Context context) {

        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        double wi = (double) width / (double) dens;
        double hi = (double) height / (double) dens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x + y);
        Log.e("screenInches", screenInches + "");
        // 大于6.9尺寸则为Pad
        return screenInches >= 6.5;
    }

    /**
     * Mac地址和IMEI组合的MD5的值
     * 获取设备唯一Id
     *
     * @return
     */
    public static String getUniqueId(Context context) {
        String adId = ACache.get(context).getAsString("AdId");
        if (!TextUtils.isEmpty(adId)) {
            return adId;
        }
        // Mac地址
        String mMacAddress = null;
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                mMacAddress = wm.getConnectionInfo().getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // IMEI地址
        String mImei = null;
        try {
            TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            mImei = TelephonyMgr.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(mMacAddress) && TextUtils.isEmpty(mImei)) {
            return ACache.get(context).getAsString("uuid");
        }
        // MD5加密
        String beforeEncryptionId = mMacAddress + mImei;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        m.update(beforeEncryptionId.getBytes(), 0, beforeEncryptionId.length());

        byte p_md5Data[] = m.digest();
        String m_szUniqueID = new String();
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
            if (b <= 0xF)
                m_szUniqueID += "0";
            m_szUniqueID += Integer.toHexString(b);
        }
        m_szUniqueID = m_szUniqueID.toUpperCase();

        return m_szUniqueID;

    }


    public static void createAdId(Context context) {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String id = "";
                try {
                    id = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
                return id;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)) {
                    ACache.get(context).put("AdId", s);
                }
            }
        };
        asyncTask.execute();
    }

}
