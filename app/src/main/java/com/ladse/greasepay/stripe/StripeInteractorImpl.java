package com.ladse.greasepay.stripe;

import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.login.LoginInteractor;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shrivats on 2/5/2017.
 */

public class StripeInteractorImpl implements StripeInteractor {
    @Override
    public void sendToken(StripeRequest stripeRequest, StripeFinishedListener stripeFinishedListener) {
            sendTokenUsingEventBus(stripeRequest, stripeFinishedListener);
    }

    @Override
    public void getStripeToken(StripeRequest stripeRequest, StripeFinishedListener stripeFinishedListener) {
            getTokenUsingEventBus(stripeRequest, stripeFinishedListener);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    void sendTokenUsingEventBus(final StripeRequest stripeRequest, final StripeFinishedListener finishedListener){
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<StripeResponse> cal = retrofitInterface.sendToken(stripeRequest);
        cal.enqueue(new Callback<StripeResponse>() {
            @Override
            public void onResponse(Call<StripeResponse> call, Response<StripeResponse> response) {
                StripeResponse stripeResponse = response.body();
                if(stripeResponse.getMessage().equals(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)){
                    finishedListener.onSuccess(stripeResponse);
                }
                else{
                    finishedListener.onError(stripeResponse);
                }
            }

            @Override
            public void onFailure(Call<StripeResponse> call, Throwable t) {
                finishedListener.onServerError();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    void getTokenUsingEventBus(final StripeRequest stripeRequest, final StripeFinishedListener finishedListener){
        ServerCall retro = ServiceGenerator.getRestWebService();
        Call<StripeTokenResponse> cal = retro.getStripeToken(stripeRequest);
        cal.enqueue(new Callback<StripeTokenResponse>() {
            @Override
            public void onResponse(Call<StripeTokenResponse> call, Response<StripeTokenResponse> response) {
                StripeTokenResponse response1 = response.body();
                if(response1.getMessage().equals(AppConstatnts.ServerResponseConstants.LOGIN_SIGNUP_SUCCESS)){
                    finishedListener.onGetTokenSuccess(response1);
                }
                else{
                    finishedListener.onError(null);
                }
            }

            @Override
            public void onFailure(Call<StripeTokenResponse> call, Throwable t) {
                finishedListener.onServerError();
            }
        });
    }
}
