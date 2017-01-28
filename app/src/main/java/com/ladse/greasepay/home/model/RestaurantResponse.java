package com.ladse.greasepay.home.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantResponse implements Serializable{
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private ArrayList<RestaurantData> data;

    public ArrayList<RestaurantData> getData() {
        return data;
    }
}
