package com.ladse.greasepay.sinup.model;

import com.google.gson.annotations.SerializedName;


public class LoginSinUpData {

    @SerializedName("auth_token")
    private String authToken;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("logged_user")
    private String loggedInUser;
    @SerializedName("type_of_user")
    private String typeOfUser;

    public String getAuthToken() {
        return authToken;
    }
}
