package com.ladse.greasepay.sinup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class SocialSinupRequest {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("is_social")
    @Expose
    private Boolean isSocial;
    @SerializedName("social_id")
    @Expose
    private String socialId;
    @SerializedName("social_type")
    @Expose
    private String socialType;
    @SerializedName("social_user_id")
    @Expose
    private String socialUserId;
    @SerializedName("social_auth_token")
    @Expose
    private String socialAuthToken;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsSocial() {
        return isSocial;
    }

    public void setIsSocial(Boolean isSocial) {
        this.isSocial = isSocial;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
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

    public String getSocialAuthToken() {
        return socialAuthToken;
    }

    public void setSocialAuthToken(String socialAuthToken) {
        this.socialAuthToken = socialAuthToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
