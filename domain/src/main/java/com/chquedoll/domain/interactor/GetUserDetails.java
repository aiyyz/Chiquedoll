package com.chquedoll.domain.interactor;

import com.chquedoll.domain.executor.PostExecutionThread;
import com.chquedoll.domain.executor.ThreadExecutor;
import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.module.LoginInResponse;
import com.chquedoll.domain.repository.UserRepository;
import com.google.common.base.Preconditions;

import io.reactivex.Observable;

/**
 * Created by super-zuo on 17-2-23.
 */

public class GetUserDetails extends UseCase<LoginInResponse, GetUserDetails.Params> {


    private final UserRepository userRepository;

    GetUserDetails(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    Observable<LoginInResponse> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return this.userRepository.user(params.userId);
    }

    static final class Params {
        private final String userId;

        private Params(String userId) {
            this.userId = userId;
        }

        public Params forUser(String userId) {
            return new Params(userId);
        }
    }
}
