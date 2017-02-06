package com.ladse.greasepay.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class BookingRedemptionRequest {
        @SerializedName("stripe_token")
        @Expose
        private String stripeToken;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("bouncer_code")
        @Expose
        private String bouncerCode;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("redemption_date")
        @Expose
        private String redemptionDate;

        public String getStripeToken() {
            return stripeToken;
        }

        public void setStripeToken(String stripeToken) {
            this.stripeToken = stripeToken;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getBouncerCode() {
            return bouncerCode;
        }

        public void setBouncerCode(String bouncerCode) {
            this.bouncerCode = bouncerCode;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getRedemptionDate() {
            return redemptionDate;
        }

        public void setRedemptionDate(String redemptionDate) {
            this.redemptionDate = redemptionDate;
        }

}
