package com.chiquedoll.data.repository;

import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.module.LoginInResponse;
import com.chquedoll.domain.repository.UserRepository;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-2-23.
 */

public class UserDataRespository implements UserRepository {



    @Override
    public Observable<LoginInResponse> user(String userId) {

        return null;
    }

}
