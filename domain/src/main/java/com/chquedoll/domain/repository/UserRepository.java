package com.chquedoll.domain.repository;

import com.chquedoll.domain.module.User;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-2-23.
 */

public interface UserRepository {

    /**
     *
     * @param userId The user id used to retrieve user data.
     * @return An Observable which emit a User.
     */
    Observable<User> user(String userId);
}
