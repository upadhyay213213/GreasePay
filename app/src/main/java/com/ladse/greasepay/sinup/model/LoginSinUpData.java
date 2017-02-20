package com.ladse.greasepay.sinup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginSinUpData {

        @SerializedName("auth_token")
        @Expose
        private String authToken;
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
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("local_profile_photo_url")
        @Expose
        private String localProfilePhotoUrl;
        @SerializedName("social_profile_url")
        @Expose
        private String socialProfileUrl;

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getLocalProfilePhotoUrl() {
            return localProfilePhotoUrl;
        }

        public void setLocalProfilePhotoUrl(String localProfilePhotoUrl) {
            this.localProfilePhotoUrl = localProfilePhotoUrl;
        }

        public String getSocialProfileUrl() {
            return socialProfileUrl;
        }

        public void setSocialProfileUrl(String socialProfileUrl) {
            this.socialProfileUrl = socialProfileUrl;
        }


    public String getAuthToken() {
        return authToken;
    }


}
