package com.ladse.greasepay.faq;

import com.google.gson.annotations.SerializedName;
import com.ladse.greasepay.common.Model;

import java.util.ArrayList;

/**
 * Created by gdz1 on 2/6/2017.
 */

public class FAQResponse extends Model {

    @SerializedName("data")
    private ArrayList<FAQData>data;

    public ArrayList<FAQData> getData() {
        return data;
    }
}


