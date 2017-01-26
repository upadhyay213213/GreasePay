package com.ladse.greasepay.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/26/17.
 */
public class LoginRequest {
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("is_social")
    private boolean isSocial;

    public LoginRequest(String userName, String password, boolean isSocial) {
        this.userName = userName;
        this.password = password;
        this.isSocial = isSocial;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSocial() {
        return isSocial;
    }

    public void setSocial(boolean social) {
        isSocial = social;
    }
}
