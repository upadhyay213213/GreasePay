package com.ladse.greasepay.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class AddRemoveFavoriteRequest {

    @SerializedName("bar_id")
    @Expose
    private String barId;
    @SerializedName("action")
    @Expose
    private String action;

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


}
