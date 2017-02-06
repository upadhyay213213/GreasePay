package com.ladse.greasepay.promocode.checkpromocode.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class CheckPromoCodeRequest {

        @SerializedName("bar_id")
        @Expose
        private String barId;
        @SerializedName("promo_code")
        @Expose
        private String promoCode;

    public CheckPromoCodeRequest(String barId, String promoCode) {
        this.barId = barId;
        this.promoCode = promoCode;
    }

    public String getBarId() {
            return barId;
        }

        public void setBarId(String barId) {
            this.barId = barId;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }

}
