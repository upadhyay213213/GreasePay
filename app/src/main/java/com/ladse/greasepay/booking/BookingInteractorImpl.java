package com.ladse.greasepay.booking;

import com.ladse.greasepay.common.Util;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingInteractorImpl implements BookingInteractor {


    @Override
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getBookingList(String authToken, final OnBookingListReceived onBookingListReceived) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<BookingListResponse> si = retrofitInterface.getBookingList(authToken);
        si.enqueue(new Callback<BookingListResponse>() {
            @Override
            public void onResponse(Call<BookingListResponse> call, Response<BookingListResponse> response) {
                BookingListResponse bookingListResponse = response.body();
                if (Util.isResponseSuccess(bookingListResponse.getSuccess())) {
                    onBookingListReceived.onBookingListResponseSuccess(bookingListResponse.getData());
                } else {
                    onBookingListReceived.onBookingListResponseError(bookingListResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<BookingListResponse> call, Throwable t) {
                onBookingListReceived.onServerError();
            }
        });

    }
}
