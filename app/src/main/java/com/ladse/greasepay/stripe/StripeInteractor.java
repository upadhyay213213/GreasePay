package com.ladse.greasepay.stripe;

/**
 * Created by Shrivats on 2/5/2017.
 */

public interface StripeInteractor {
    interface StripeFinishedListener{
        void onSuccess(StripeResponse stripeResponse);
        void onGetTokenSuccess(StripeTokenResponse stripeTokenResponse);
        void onError(StripeResponse stripeResponse);
        void onServerError();
    }
    void sendToken(StripeRequest stripeRequest, StripeFinishedListener stripeFinishedListener);
    void getStripeToken(StripeRequest stripeRequest, StripeFinishedListener stripeFinishedListener);
}
