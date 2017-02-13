package com.ladse.greasepay.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class SocialLoginResponseData {

    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("social_type")
    @Expose
    private String socialType;
    @SerializedName("social_user_id")
    @Expose
    private String socialUserId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("logged_user")
    @Expose
    private String loggedUser;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("type_of_user")
    @Expose
    private String typeOfUser;
    @SerializedName("is_social")
    @Expose
    private Boolean isSocial;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getSocialType() {
        return socialType;
    }

    public void setSocialType(String socialType) {
        this.socialType = socialType;
    }

    public String getSocialUserId() {
        return socialUserId;
    }

    public void setSocialUserId(String socialUserId) {
        this.socialUserId = socialUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public Boolean getIsSocial() {
        return isSocial;
    }

    public void setIsSocial(Boolean isSocial) {
        this.isSocial = isSocial;
    }


}
