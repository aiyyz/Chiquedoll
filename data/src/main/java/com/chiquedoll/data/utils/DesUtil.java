package com.chiquedoll.data.utils;

import android.util.Base64;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by super-zuo on 17-2-10.
 */

public class DesUtil {

    public static final String PASSWORD = "shanghai";

    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};


    public static String encryptDES(String encryptString, String password) throws Exception {

        try {
            DESKeySpec dks = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
            return new String(Base64.encode(encryptedData,Base64.DEFAULT));
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Security exception", e);
        }

    }

    public static String encryptDES(String encryptString) throws Exception {
        // IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(PASSWORD.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return new String(Base64.encode(encryptedData,Base64.DEFAULT));
    }

    public static String decryptDES(String decryptString) {

        try {
            byte[] byteMi = Base64.decode(decryptString,Base64.DEFAULT);
            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            // IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
            SecretKeySpec key = new SecretKeySpec(PASSWORD.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte decryptedData[] = cipher.doFinal(byteMi);
            return new String(decryptedData);
        } catch (Exception e) {
        }
        return null;

    }
}
