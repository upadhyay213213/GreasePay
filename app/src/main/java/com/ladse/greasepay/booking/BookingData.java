package com.ladse.greasepay.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class BookingData {
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("restaurant_id")
        @Expose
        private String restaurantId;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("male_person_per_fees")
        @Expose
        private String malePersonPerFees;
        @SerializedName("female_person_per_fees")
        @Expose
        private String femalePersonPerFees;
        @SerializedName("male_entry_free")
        @Expose
        private String maleEntryFree;
        @SerializedName("order_date")
        @Expose
        private String orderDate;
        @SerializedName("order_date_strtotime")
        @Expose
        private Integer orderDateStrtotime;
        @SerializedName("female_entry_free")
        @Expose
        private String femaleEntryFree;
        @SerializedName("number_of_men")
        @Expose
        private String numberOfMen;
        @SerializedName("number_of_women")
        @Expose
        private String numberOfWomen;
        @SerializedName("promo_code")
        @Expose
        private String promoCode;
        @SerializedName("price_for_men")
        @Expose
        private String priceForMen;
        @SerializedName("price_for_women")
        @Expose
        private String priceForWomen;
        @SerializedName("promo_discount")
        @Expose
        private String promoDiscount;
        @SerializedName("tax_fees")
        @Expose
        private String taxFees;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("advance_booking_fees")
        @Expose
        private String advanceBookingFees;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("redemption_date")
        @Expose
        private String redemptionDate;
        @SerializedName("redemption_date_strtotime")
        @Expose
        private Boolean redemptionDateStrtotime;
        @SerializedName("order_created_date")
        @Expose
        private String orderCreatedDate;
        @SerializedName("order_created_date_strtotime")
        @Expose
        private Integer orderCreatedDateStrtotime;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getMalePersonPerFees() {
            return malePersonPerFees;
        }

        public void setMalePersonPerFees(String malePersonPerFees) {
            this.malePersonPerFees = malePersonPerFees;
        }

        public String getFemalePersonPerFees() {
            return femalePersonPerFees;
        }

        public void setFemalePersonPerFees(String femalePersonPerFees) {
            this.femalePersonPerFees = femalePersonPerFees;
        }

        public String getMaleEntryFree() {
            return maleEntryFree;
        }

        public void setMaleEntryFree(String maleEntryFree) {
            this.maleEntryFree = maleEntryFree;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public Integer getOrderDateStrtotime() {
            return orderDateStrtotime;
        }

        public void setOrderDateStrtotime(Integer orderDateStrtotime) {
            this.orderDateStrtotime = orderDateStrtotime;
        }

        public String getFemaleEntryFree() {
            return femaleEntryFree;
        }

        public void setFemaleEntryFree(String femaleEntryFree) {
            this.femaleEntryFree = femaleEntryFree;
        }

        public String getNumberOfMen() {
            return numberOfMen;
        }

        public void setNumberOfMen(String numberOfMen) {
            this.numberOfMen = numberOfMen;
        }

        public String getNumberOfWomen() {
            return numberOfWomen;
        }

        public void setNumberOfWomen(String numberOfWomen) {
            this.numberOfWomen = numberOfWomen;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }

        public String getPriceForMen() {
            return priceForMen;
        }

        public void setPriceForMen(String priceForMen) {
            this.priceForMen = priceForMen;
        }

        public String getPriceForWomen() {
            return priceForWomen;
        }

        public void setPriceForWomen(String priceForWomen) {
            this.priceForWomen = priceForWomen;
        }

        public String getPromoDiscount() {
            return promoDiscount;
        }

        public void setPromoDiscount(String promoDiscount) {
            this.promoDiscount = promoDiscount;
        }

        public String getTaxFees() {
            return taxFees;
        }

        public void setTaxFees(String taxFees) {
            this.taxFees = taxFees;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getAdvanceBookingFees() {
            return advanceBookingFees;
        }

        public void setAdvanceBookingFees(String advanceBookingFees) {
            this.advanceBookingFees = advanceBookingFees;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRedemptionDate() {
            return redemptionDate;
        }

        public void setRedemptionDate(String redemptionDate) {
            this.redemptionDate = redemptionDate;
        }

        public Boolean getRedemptionDateStrtotime() {
            return redemptionDateStrtotime;
        }

        public void setRedemptionDateStrtotime(Boolean redemptionDateStrtotime) {
            this.redemptionDateStrtotime = redemptionDateStrtotime;
        }

        public String getOrderCreatedDate() {
            return orderCreatedDate;
        }

        public void setOrderCreatedDate(String orderCreatedDate) {
            this.orderCreatedDate = orderCreatedDate;
        }

        public Integer getOrderCreatedDateStrtotime() {
            return orderCreatedDateStrtotime;
        }

        public void setOrderCreatedDateStrtotime(Integer orderCreatedDateStrtotime) {
            this.orderCreatedDateStrtotime = orderCreatedDateStrtotime;
        }



}
