package com.ladse.greasepay.upcomingevents;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public class EventResponse {
    @SerializedName("success")
    private  String success;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<EventData>data;


    public ArrayList<EventData> getData() {
        return data;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
