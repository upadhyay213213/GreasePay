package com.ladse.greasepay.upcomingevents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventData {
        @SerializedName("event_id")
        @Expose
        private String eventId;
        @SerializedName("restaurant_id")
        @Expose
        private String restaurantId;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("bar_type")
        @Expose
        private String barType;
        @SerializedName("event_name")
        @Expose
        private String eventName;
        @SerializedName("start_date_time")
        @Expose
        private String startDateTime;
        @SerializedName("start_date_time_strtotime")
        @Expose
        private Integer startDateTimeStrtotime;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("entry_fees")
        @Expose
        private String entryFees;
        @SerializedName("distance")
        @Expose
        private String distance;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
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

        public String getBarType() {
            return barType;
        }

        public void setBarType(String barType) {
            this.barType = barType;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getStartDateTime() {
            return startDateTime;
        }

        public void setStartDateTime(String startDateTime) {
            this.startDateTime = startDateTime;
        }

        public Integer getStartDateTimeStrtotime() {
            return startDateTimeStrtotime;
        }

        public void setStartDateTimeStrtotime(Integer startDateTimeStrtotime) {
            this.startDateTimeStrtotime = startDateTimeStrtotime;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEntryFees() {
            return entryFees;
        }

        public void setEntryFees(String entryFees) {
            this.entryFees = entryFees;
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

}
