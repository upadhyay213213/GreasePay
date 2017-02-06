package com.ladse.greasepay.stripe;

import com.google.gson.annotations.SerializedName;
import com.ladse.greasepay.common.Model;

/**
 * Created by Shrivats on 2/5/2017.
 */

public class StripeResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;

    public StripeResponse() {

    }

    @Override
    public String toString() {
        return "StripeResponse{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                '}';
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
}
