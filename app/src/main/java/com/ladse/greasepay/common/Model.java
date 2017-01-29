package com.ladse.greasepay.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/29/17.
 */
public class Model {
    @SerializedName("success")
    protected String success;
    @SerializedName("message")
    protected String message;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
