package com.ladse.greasepay.model;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class OutletModel {
    private String outletName;
    private String outletAddress;
    private int outletDistance;
    private boolean isFavorite;
    private String outletImageUrl;

    public OutletModel() {
    }

    public OutletModel(String outletName, String outletAddress, int outletDistance, boolean isFavorite, String outletImageUrl) {
        this.outletName = outletName;
        this.outletAddress = outletAddress;
        this.outletDistance = outletDistance;
        this.isFavorite = isFavorite;
        this.outletImageUrl = outletImageUrl;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletAddress() {
        return outletAddress;
    }

    public void setOutletAddress() {
        this.outletAddress = "add, address";
    }

    public int getOutletDistance() {
        return outletDistance;
    }

    public void setOutletDistance(int outletDistance) {
        this.outletDistance = outletDistance;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getOutletImageUrl() {
        return outletImageUrl;
    }

    public void setOutletImageUrl(String outletImageUrl) {
        this.outletImageUrl = outletImageUrl;
    }
}
