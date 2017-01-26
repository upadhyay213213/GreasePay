package com.ladse.greasepay.sinup.model;

import com.google.gson.annotations.SerializedName;

public class SinUpResponse {
    @SerializedName("success")
    private  String success;

    @SerializedName("message")
    private String message;

    @SerializedName("")
    private String data;

    @Override
    public String toString() {
        return "SinUpResponse{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
