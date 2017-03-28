package com.chquedoll.domain.exception;

/**
 * Created by super-zuo on 17-3-16.
 */

public class ApiException extends Exception{


    public static final int STATUS_CODE_SUCCESS = 200;

    public ApiException(int code, String result) {

    }
}
