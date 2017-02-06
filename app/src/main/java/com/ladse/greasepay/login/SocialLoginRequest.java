package com.ladse.greasepay.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class SocialLoginRequest {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("is_social")
        @Expose
        private Boolean isSocial;
        @SerializedName("social_type")
        @Expose
        private String socialType;
        @SerializedName("social_id")
        @Expose
        private String socialId;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Boolean getIsSocial() {
            return isSocial;
        }

        public void setIsSocial(Boolean isSocial) {
            this.isSocial = isSocial;
        }

        public String getSocialType() {
            return socialType;
        }

        public void setSocialType(String socialType) {
            this.socialType = socialType;
        }

        public String getSocialId() {
            return socialId;
        }

        public void setSocialId(String socialId) {
            this.socialId = socialId;
        }
}
