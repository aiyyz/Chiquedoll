package com.chquedoll.domain.interactor;

import com.chquedoll.domain.exception.ApiException;
import com.chquedoll.domain.module.BaseResponse;

import io.reactivex.functions.Function;

/**
 * Created by super-zuo on 17-3-16.
 */

public class ResponseFilter<T> implements Function<BaseResponse<T>, T> {

    @Override
    public T apply(BaseResponse<T> tBaseResponse) throws Exception {
        if (tBaseResponse.code != ApiException.STATUS_CODE_SUCCESS) {
            throw new ApiException(tBaseResponse.code, ((String) tBaseResponse.result));
        }
        return tBaseResponse.result;
    }
}
