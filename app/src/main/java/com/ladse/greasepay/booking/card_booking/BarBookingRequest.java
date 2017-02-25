package com.ladse.greasepay.booking.card_booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pkatya on 2/12/17.
 */
public class BarBookingRequest implements Serializable {
        @SerializedName("stripe_token")
        @Expose
        private String stripeToken;
        @SerializedName("bar_id")
        @Expose
        private String barId;
        @SerializedName("male_person_per_fees")
        @Expose
        private String malePersonPerFees;
        @SerializedName("female_person_per_fees")
        @Expose
        private String femalePersonPerFees;
        @SerializedName("order_date")
        @Expose
        private String orderDate;
        @SerializedName("male_entry_free")
        @Expose
        private String maleEntryFree;
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
        @SerializedName("booking_type")
        @Expose
        private String bookingType;
        @SerializedName("event_id")
        @Expose
        private Integer eventId;

        public String getStripeToken() {
            return stripeToken;
        }

        public void setStripeToken(String stripeToken) {
            this.stripeToken = stripeToken;
        }

        public String getBarId() {
            return barId;
        }

        public void setBarId(String barId) {
            this.barId = barId;
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

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getMaleEntryFree() {
            return maleEntryFree;
        }

        public void setMaleEntryFree(String maleEntryFree) {
            this.maleEntryFree = maleEntryFree;
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

        public String getBookingType() {
            return bookingType;
        }

        public void setBookingType(String bookingType) {
            this.bookingType = bookingType;
        }

        public Integer getEventId() {
            return eventId;
        }

        public void setEventId(Integer eventId) {
            this.eventId = eventId;
        }

    }

