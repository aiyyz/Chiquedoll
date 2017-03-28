package com.chquedoll.domain.repository;

import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.module.LoginInResponse;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-2-23.
 */

public interface UserRepository {

    /**
     *
     * @param userId The user id used to retrieve user data.
     * @return An Observable which emit a LoginInResponse.
     */
    Observable<LoginInResponse> user(String userId);
}
