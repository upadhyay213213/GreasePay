package com.ladse.greasepay.sinup;

import com.ladse.greasepay.sinup.model.LoginSinUpResponse;


public interface SignUpInteractor {
    void sinup(SignUpRequest signUpRequest,OnSinUpResponseListener onSinUpResponseListener);

    interface OnSinUpResponseListener{
        void onSuccess(LoginSinUpResponse loginSinUpResponse);
        void onError(LoginSinUpResponse loginSinUpResponse);
        void onServerError();
    }
}
