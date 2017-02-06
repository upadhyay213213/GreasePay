package com.ladse.greasepay.stripe;

/**
 * Created by Shrivats on 2/5/2017.
 */

public interface StripePresenter {
    void sendStripeToken(String stripeToken, String card_last_digit);
}
