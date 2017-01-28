package com.ladse.greasepay.promocode.checkpromocode.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class CheckPromoCodeData {

        @SerializedName("bar_id")
        @Expose
        private String barId;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("promo_code")
        @Expose
        private String promoCode;
        @SerializedName("expiry_date")
        @Expose
        private String expiryDate;
        @SerializedName("expiry_date_strtotime")
        @Expose
        private Integer expiryDateStrtotime;
        @SerializedName("discount")
        @Expose
        private String discount;

        public String getBarId() {
            return barId;
        }

        public void setBarId(String barId) {
            this.barId = barId;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }

        public Integer getExpiryDateStrtotime() {
            return expiryDateStrtotime;
        }

        public void setExpiryDateStrtotime(Integer expiryDateStrtotime) {
            this.expiryDateStrtotime = expiryDateStrtotime;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }


}
