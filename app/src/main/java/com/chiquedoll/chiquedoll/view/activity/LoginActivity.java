package com.chiquedoll.chiquedoll.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chiquedoll.chiquedoll.R;
import com.chiquedoll.chiquedoll.view.AppConstants;
import com.chiquedoll.data.net.Api.RestApi;
import com.chiquedoll.data.net.ApiConnection;
import com.chiquedoll.data.net.HeadInterceptor;
import com.chquedoll.domain.module.BaseResponse;
import com.chquedoll.domain.module.LoginInResponse;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by super-zuo on 17-3-13.
 */

public class LoginActivity extends RxActivity {

    private TextView tv_email;
    private TextView tv_password;
    private Button bt_login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_password = (TextView) findViewById(R.id.tv_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        initEvent();
    }

    private void initEvent() {
        RxView.clicks(bt_login)
                .throttleFirst(AppConstants.ONE_CLICK_DURATION, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> login());
    }

    private void login() {
        String password = tv_password.getText().toString().trim();
        String email = tv_email.getText().toString().trim();
        Observable<BaseResponse<LoginInResponse>> userObservable = ApiConnection.getInstance(this)
                .createApi(RestApi.class)
                .login(AppConstants.LOGIN_URL_DEBUG, email, password);
        execute(new UserSubscriber(), userObservable);
    }

    private class UserSubscriber extends DisposableObserver<LoginInResponse> {


        private ProgressDialog dialog;

        @Override
        protected void onStart() {
            super.onStart();
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.show();
        }

        @Override
        public void onNext(LoginInResponse loginInResponse) {
            Toast.makeText(LoginActivity.this, loginInResponse.getAccessToken(), Toast.LENGTH_LONG).show();
            HeadInterceptor.setAccessToken(loginInResponse.getAccessToken());
            HeadInterceptor.setUserId(loginInResponse.getCustomer().getId());
        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }

        @Override
        public void onComplete() {
            Toast.makeText(LoginActivity.this, "complete", Toast.LENGTH_LONG).show();
            dialog.dismiss();
            startActivity(new Intent(LoginActivity.this,ProductDetailActivity.class));
        }
    }
}
