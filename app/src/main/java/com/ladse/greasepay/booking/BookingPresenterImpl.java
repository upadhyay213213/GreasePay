package com.ladse.greasepay.booking;

import android.content.Context;

import com.ladse.greasepay.common.AppSharedPreference;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/29/17.
 */
public class BookingPresenterImpl implements BookingPresenter,BookingInteractor.OnBookingListReceived {
    private BookingView bookingView;
    private BookingInteractor bookingInteractor;
    private Context context;

    public BookingPresenterImpl(BookingView bookingView, Context context) {
        this.bookingView = bookingView;
        this.context = context;
        bookingInteractor=new BookingInteractorImpl();
    }

    @Override
    public void getBookingList() {
        bookingInteractor.getBookingList(AppSharedPreference.getAuthToken(context), this);
    }

    @Override
    public void onBookingListResponseSuccess(ArrayList<BookingData> bookingDataArrayList) {
        bookingView.onSuccess(bookingDataArrayList);

    }

    @Override
    public void onBookingListResponseError(String message) {
bookingView.onError(message);
    }

    @Override
    public void onServerError() {
bookingView.onServerError();
    }
}
