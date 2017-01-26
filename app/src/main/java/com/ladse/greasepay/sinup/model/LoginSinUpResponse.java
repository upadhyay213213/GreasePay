package com.ladse.greasepay.sinup.model;

import com.google.gson.annotations.SerializedName;

public class LoginSinUpResponse {
    @SerializedName("success")
    private  String success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private LoginSinUpData data;

    @Override
    public String toString() {
        return "LoginSinUpResponse{" +
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

    public LoginSinUpData getData() {
        return data;
    }

    public void setData(LoginSinUpData data) {
        this.data = data;
    }
}
