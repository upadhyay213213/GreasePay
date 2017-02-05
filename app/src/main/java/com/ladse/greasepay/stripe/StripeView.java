package com.ladse.greasepay.stripe;

/**
 * Created by Shrivats on 2/5/2017.
 */

public interface StripeView {
    void setTokenSendSuccessful(StripeResponse stripeResponse);
    void setTokenSendFail(String message);
}
