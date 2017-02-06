package com.ladse.greasepay.debitcard.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pkatya on 2/5/17.
 */
public class CardRequest {
        @SerializedName("number")
        @Expose
        private String number;
        @SerializedName("exp")
        @Expose
        private String exp;
        @SerializedName("cvv")
        @Expose
        private String cvv;
        @SerializedName("default")
        @Expose
        private String _default;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("zip")
        @Expose
        private String zip;

    public CardRequest(String number, String exp, String cvv, String _default, String name, String zip) {
        this.number = number;
        this.exp = exp;
        this.cvv = cvv;
        this._default = _default;
        this.name = name;
        this.zip = zip;
    }

    public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getExp() {
            return exp;
        }

        public void setExp(String exp) {
            this.exp = exp;
        }

        public String getCvv() {
            return cvv;
        }

        public void setCvv(String cvv) {
            this.cvv = cvv;
        }

        public String getDefault() {
            return _default;
        }

        public void setDefault(String _default) {
            this._default = _default;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

}

