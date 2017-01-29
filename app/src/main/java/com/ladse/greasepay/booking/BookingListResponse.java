package com.ladse.greasepay.booking;

import com.ladse.greasepay.common.Model;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/28/17.
 */
public class BookingListResponse extends Model {
    private ArrayList<BookingData>data;

    public ArrayList<BookingData> getData() {
        return data;
    }
}
