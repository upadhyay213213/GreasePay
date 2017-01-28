package com.ladse.greasepay.promocode.checkpromocode.controler;

import com.ladse.greasepay.common.Util;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pkatya on 1/28/17.
 */
public class CheckPromoCodeInteracterImpl implements CheckPromoCodeInteracter {

    @Override
    public void validateFromoCode(String authToken, CheckPromoCodeRequest checkPromoCodeRequest, final onValidatePromoCode onValidatePromoCode) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<CheckPromoCodeResponse> si = retrofitInterface.checkPromoCode(authToken, checkPromoCodeRequest);
        si.enqueue(new Callback<CheckPromoCodeResponse>() {
            @Override
            public void onResponse(Call<CheckPromoCodeResponse> call, Response<CheckPromoCodeResponse> response) {
                CheckPromoCodeResponse checkPromoCodeResponse = response.body();
                if (Util.isResponseSuccess(checkPromoCodeResponse.getSuccess())) {
                    onValidatePromoCode.onValidatePromoCodeResponseReceived(checkPromoCodeResponse.getData());
                } else {
                    onValidatePromoCode.onValidatePromoCodeErrorReceived(checkPromoCodeResponse.getMessage());
                }

            }

            @Override
            public void onFailure(Call<CheckPromoCodeResponse> call, Throwable t) {
                onValidatePromoCode.onValidatePromoCodeServerError();
            }
        });
    }
}
