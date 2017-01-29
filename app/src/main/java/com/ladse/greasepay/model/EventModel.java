package com.ladse.greasepay.model;

/**
 * Created by User on 1/29/2017.
 */

public class EventModel {
    private String mOutletName, mOutletAddress, mOutletType, mEventName, mEntryFees, mEventDistance, mOutletImageUrl;
    private int mEventId, mOutletId;
    private String mEventDate;

    public EventModel() {
    }

    public EventModel(String mOutletName, String mOutletAddress, String mOutletType, String mEventName, String mEntryFees, String mEventDistance, String mOutletImageUrl, int mEventId, int mOutletId, String mEventDate) {
        this.mOutletName = mOutletName;
        this.mOutletAddress = mOutletAddress;
        this.mOutletType = mOutletType;
        this.mEventName = mEventName;
        this.mEntryFees = mEntryFees;
        this.mEventDistance = mEventDistance;
        this.mOutletImageUrl = mOutletImageUrl;
        this.mEventId = mEventId;
        this.mOutletId = mOutletId;
        this.mEventDate = mEventDate;
    }

    public String getmOutletName() {
        return mOutletName;
    }

    public void setmOutletName(String mOutletName) {
        this.mOutletName = mOutletName;
    }

    public String getmOutletAddress() {
        return mOutletAddress;
    }

    public void setmOutletAddress(String mOutletAddress) {
        this.mOutletAddress = mOutletAddress;
    }

    public String getmOutletType() {
        return mOutletType;
    }

    public void setmOutletType(String mOutletType) {
        this.mOutletType = mOutletType;
    }

    public String getmEventName() {
        return mEventName;
    }

    public void setmEventName(String mEventName) {
        this.mEventName = mEventName;
    }

    public String getmEntryFees() {
        return mEntryFees;
    }

    public void setmEntryFees(String mEntryFees) {
        this.mEntryFees = mEntryFees;
    }

    public String getmEventDistance() {
        return mEventDistance;
    }

    public void setmEventDistance(String mEventDistance) {
        this.mEventDistance = mEventDistance;
    }

    public String getmOutletImageUrl() {
        return mOutletImageUrl;
    }

    public void setmOutletImageUrl(String mOutletImageUrl) {
        this.mOutletImageUrl = mOutletImageUrl;
    }

    public int getmEventId() {
        return mEventId;
    }

    public void setmEventId(int mEventId) {
        this.mEventId = mEventId;
    }

    public int getmOutletId() {
        return mOutletId;
    }

    public void setmOutletId(int mOutletId) {
        this.mOutletId = mOutletId;
    }

    public String getmEventDate() {
        return mEventDate;
    }

    public void setmEventDate(String mEventDate) {
        this.mEventDate = mEventDate;
    }
}
