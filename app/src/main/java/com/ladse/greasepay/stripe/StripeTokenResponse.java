package com.ladse.greasepay.stripe;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shrivats on 2/7/2017.
 */

public class StripeTokenResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private StripeData stripeData;

    public StripeTokenResponse(String success, String message, StripeData stripeData) {
        this.success = success;
        this.message = message;
        this.stripeData = stripeData;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StripeData getStripeData() {
        return stripeData;
    }

    public void setStripeData(StripeData stripeData) {
        this.stripeData = stripeData;
    }
}
