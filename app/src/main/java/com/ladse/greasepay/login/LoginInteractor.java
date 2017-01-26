package com.ladse.greasepay.login;

import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

/**
 * Created by pkatya on 1/26/17.
 *
 */
public interface LoginInteractor {
    interface LoginFinishedListener{
        void onSuccess(LoginSinUpResponse loginSinUpResponse);
        void onError(LoginSinUpResponse loginSinUpResponse);
        void onServerError();
    }
    void login(LoginRequest loginRequest,LoginFinishedListener listener);

}

