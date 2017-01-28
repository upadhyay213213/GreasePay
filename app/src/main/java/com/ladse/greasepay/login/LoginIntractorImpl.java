package com.ladse.greasepay.login;

import android.os.AsyncTask;

import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkatya on 1/26/17.
 */
public class LoginIntractorImpl implements LoginInteractor {

    class LoginCall extends AsyncTask<Void,Void,Void>{
        LoginRequest loginRequest;
        LoginFinishedListener loginFinishedListener;

        public LoginCall(LoginRequest loginRequest, LoginFinishedListener loginFinishedListener) {
            this.loginRequest = loginRequest;
            this.loginFinishedListener = loginFinishedListener;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
            Call<LoginSinUpResponse> si = retrofitInterface.login(loginRequest);
            si.enqueue(new Callback<LoginSinUpResponse>() {
                @Override
                public void onResponse(Call<LoginSinUpResponse> call, Response<LoginSinUpResponse> response) {
                    LoginSinUpResponse loginSinUpResponse = response.body();
                    if (loginSinUpResponse.getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)) {
                        loginFinishedListener.onSuccess(loginSinUpResponse);
                    } else {
                        loginFinishedListener.onError(loginSinUpResponse);
                    }

                }

                @Override
                public void onFailure(Call<LoginSinUpResponse> call, Throwable t) {
                    loginFinishedListener.onServerError();
                }
            });
            return null;
        }

    }

    @Override

    public void login(LoginRequest loginRequest, final LoginFinishedListener listener) {
       //new LoginCall(loginRequest,listener).execute();
        loginUsingEventBus(loginRequest,listener);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void loginUsingEventBus(LoginRequest loginRequest, final LoginFinishedListener loginFinishedListener) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<LoginSinUpResponse> si = retrofitInterface.login(loginRequest);
        si.enqueue(new Callback<LoginSinUpResponse>() {
            @Override
            public void onResponse(Call<LoginSinUpResponse> call, Response<LoginSinUpResponse> response) {
                LoginSinUpResponse loginSinUpResponse = response.body();
                if (loginSinUpResponse.getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)) {
                    loginFinishedListener.onSuccess(loginSinUpResponse);
                } else {
                    loginFinishedListener.onError(loginSinUpResponse);
                }

            }

            @Override
            public void onFailure(Call<LoginSinUpResponse> call, Throwable t) {
                loginFinishedListener.onServerError();
            }
        });
    }


}
