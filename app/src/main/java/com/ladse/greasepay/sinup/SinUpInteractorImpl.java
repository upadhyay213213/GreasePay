package com.ladse.greasepay.sinup;


import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SinUpInteractorImpl implements SignUpInteractor {


    @Override
    public void sinup(SignUpRequest signUpRequest, final SignUpInteractor.OnSinUpResponseListener listener) {

        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<LoginSinUpResponse> si = retrofitInterface.sinUp(signUpRequest);
        si.enqueue(new Callback<LoginSinUpResponse>() {
            @Override
            public void onResponse(Call<LoginSinUpResponse> call, Response<LoginSinUpResponse> response) {
                LoginSinUpResponse loginSinUpResponse = response.body();
                if (loginSinUpResponse.getSuccess().equalsIgnoreCase(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)) {
                    listener.onSuccess(loginSinUpResponse);

                } else {
                    listener.onError(loginSinUpResponse);
                }

            }

            @Override
            public void onFailure(Call<LoginSinUpResponse> call, Throwable t) {

            }
        });
    }
}
