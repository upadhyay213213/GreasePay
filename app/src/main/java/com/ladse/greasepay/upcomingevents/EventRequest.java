package com.ladse.greasepay.upcomingevents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventRequest {
    @SerializedName("latitude")
    @Expose
    private String latitude= "29.2766076";
    @SerializedName("longitude")
    @Expose
    private String longitude="-94.8335742";

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

}
