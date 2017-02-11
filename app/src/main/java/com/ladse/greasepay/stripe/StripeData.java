package com.ladse.greasepay.stripe;

/**
 * Created by Shrivats on 2/7/2017.
 */

public class StripeData {
    private String stripeToken;

    public StripeData(String stripeToken) {
        this.stripeToken = stripeToken;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }
}
