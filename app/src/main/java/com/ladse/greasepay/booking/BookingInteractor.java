package com.ladse.greasepay.booking;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/29/17.
 */
public interface BookingInteractor {
    void getBookingList(String authToken,OnBookingListReceived onBookingListReceived);

    interface OnBookingListReceived{
        void onBookingListResponseSuccess(ArrayList<BookingData> bookingDataArrayList);
        void onBookingListResponseError(String message);
        void onServerError();
    }
}
