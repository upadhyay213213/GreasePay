package com.ladse.greasepay.booking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;

import java.util.ArrayList;

public class BookingListActivity extends AppCompatActivity implements BookingView {

    private BookingPresenter bookingPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        //bookingPresenter=new BookingPresenterImpl(this);
    }


    @Override
    public void onSuccess(Object objects) {
        ArrayList<BookingData>bookingDataArrayList=(ArrayList<BookingData>)objects;
        Log.v("bookingDataArrayList",bookingDataArrayList.toString());

    }

    @Override
    public Void onError(String message) {
        AlertManager.showErrorDialog(this,message);
        return null;
    }

    @Override
    public Void onServerError() {
        AlertManager.showErrorDialog(this,getString(R.string.server_error));
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookingPresenter.getBookingList();
    }
}
