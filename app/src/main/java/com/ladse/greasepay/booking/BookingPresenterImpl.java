package com.ladse.greasepay.booking;

import android.content.Context;

import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;

import java.util.ArrayList;

/**
 * Created by pkatya on 1/29/17.
 */
public class BookingPresenterImpl implements BookingPresenter,BookingInteractor.OnBookingListReceived {
    private BookingView bookingView;
    private BookingInteractor bookingInteractor;

    public BookingPresenterImpl(BookingView bookingView) {
        this.bookingView = bookingView;
        bookingInteractor=new BookingInteractorImpl();
    }

    @Override
    public void getBookingList() {
        AlertManager.showProgressDialog((Context) bookingView);
        bookingInteractor.getBookingList(AppSharedPreference.getAuthToken((BookingListActivity) bookingView),this);
    }

    @Override
    public void onBookingListResponseSuccess(ArrayList<BookingData> bookingDataArrayList) {
        AlertManager.disMissDialog();
        bookingView.onSuccess(bookingDataArrayList);

    }

    @Override
    public void onBookingListResponseError(String message) {
bookingView.onError(message);
        AlertManager.disMissDialog();
    }

    @Override
    public void onServerError() {
        AlertManager.disMissDialog();
bookingView.onServerError();
    }
}
