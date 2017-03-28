package com.chquedoll.domain.module;

/**
 * Created by super-zuo on 17-3-16.
 */

public class BaseResponse<T> {
    public boolean success;
    public int code;
    public T result;
}
