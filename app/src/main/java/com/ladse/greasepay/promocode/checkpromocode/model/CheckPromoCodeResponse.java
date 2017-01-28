package com.ladse.greasepay.promocode.checkpromocode.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class CheckPromoCodeResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private CheckPromoCodeData data;

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

    public CheckPromoCodeData getData() {
        return data;
    }

    public void setData(CheckPromoCodeData data) {
        this.data = data;
    }
}
