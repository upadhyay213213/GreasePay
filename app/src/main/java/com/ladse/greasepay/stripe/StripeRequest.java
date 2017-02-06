package com.ladse.greasepay.stripe;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shrivats on 2/5/2017.
 */

public class StripeRequest {
    @SerializedName("stripe_token")
    private String stripe_token;
    @SerializedName("card_last_digit")
    private String card_last_digit;

    public StripeRequest() {
    }

    public String getStripe_token() {
        return stripe_token;
    }

    public void setStripe_token(String stripe_token) {
        this.stripe_token = stripe_token;
    }

    public String getCard_last_digit() {
        return card_last_digit;
    }

    public void setCard_last_digit(String card_last_digit) {
        this.card_last_digit = card_last_digit;
    }
}
