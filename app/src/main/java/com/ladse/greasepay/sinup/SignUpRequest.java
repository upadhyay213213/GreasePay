package com.ladse.greasepay.sinup;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/26/17.
 */
public class SignUpRequest {
    @SerializedName("first_name")
    private String fName;
    @SerializedName("last_name")
    private String lName;
    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("password")
    private String password;
    @SerializedName("is_social")
    private boolean isSocial;

    public SignUpRequest(String fName, String lName, String email, String phoneNumber, String password,boolean isSocial) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isSocial=isSocial;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
