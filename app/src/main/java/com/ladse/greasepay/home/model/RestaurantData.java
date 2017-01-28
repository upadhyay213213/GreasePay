package com.ladse.greasepay.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pkatya on 1/27/17.
 */
public class RestaurantData implements Serializable{
        @SerializedName("restaurant_id")
        @Expose
        private String restaurantId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("bar_type")
        @Expose
        private String barType;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("male_person_per_fees")
        @Expose
        private String malePersonPerFees;
        @SerializedName("female_person_per_fees")
        @Expose
        private String femalePersonPerFees;
        @SerializedName("tax_fees")
        @Expose
        private String taxFees;
        @SerializedName("male_entry_free")
        @Expose
        private Boolean maleEntryFree;
        @SerializedName("female_entry_free")
        @Expose
        private Boolean femaleEntryFree;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("distance")
        @Expose
        private String distance;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("advance_booking_fees")
        @Expose
        private String advanceBookingFees;
        @SerializedName("favorite")
        @Expose
        private Boolean favorite;

        public String getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getBarType() {
            return barType;
        }

        public void setBarType(String barType) {
            this.barType = barType;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getTaxFees() {
            return taxFees;
        }

        public void setTaxFees(String taxFees) {
            this.taxFees = taxFees;
        }

        public Boolean getMaleEntryFree() {
            return maleEntryFree;
        }

        public void setMaleEntryFree(Boolean maleEntryFree) {
            this.maleEntryFree = maleEntryFree;
        }

        public Boolean getFemaleEntryFree() {
            return femaleEntryFree;
        }

        public void setFemaleEntryFree(Boolean femaleEntryFree) {
            this.femaleEntryFree = femaleEntryFree;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAdvanceBookingFees() {
            return advanceBookingFees;
        }

        public void setAdvanceBookingFees(String advanceBookingFees) {
            this.advanceBookingFees = advanceBookingFees;
        }

        public Boolean getFavorite() {
            return favorite;
        }

        public void setFavorite(Boolean favorite) {
            this.favorite = favorite;
        }



}
