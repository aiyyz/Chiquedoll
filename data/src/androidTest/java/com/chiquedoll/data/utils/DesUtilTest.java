package com.chiquedoll.data.utils;

import android.util.Log;

import org.junit.Test;

/**
 * Created by super-zuo on 17-2-10.
 */
public class DesUtilTest {


    @Test
    public void encryptDES() throws Exception {
        String s = DesUtil.encryptDES("i love you");
        Log.e("desutilstest", s);
    }

    @Test
    public void decryptDES() throws Exception {
        String des = DesUtil.decryptDES("PaG526qpBula8y5sCqmktA==");
        Log.e("desutilstest", des);

    }

}