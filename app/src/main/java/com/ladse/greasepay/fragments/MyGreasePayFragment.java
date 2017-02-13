package com.ladse.greasepay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ladse.greasepay.R;
import com.ladse.greasepay.booking.BookingData;
import com.ladse.greasepay.booking.BookingPresenter;
import com.ladse.greasepay.booking.BookingPresenterImpl;
import com.ladse.greasepay.booking.BookingRedemptionRequest;
import com.ladse.greasepay.booking.BookingView;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.stripe.StripeResponse;
import com.ladse.greasepay.stripe.StripeTokenResponse;
import com.ladse.greasepay.stripe.StripeView;
import com.ladse.greasepay.utils.BookingListAdapter;
import com.ladse.greasepay.webclient_retro.GetDataFromServer;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGreasePayFragment extends Fragment implements BookingView, StripeView {

    private RecyclerView bookingListRecycler;
    private ArrayList<BookingData> bookingDatas;
    private BookingPresenter presenter;
    private String stripeToken;
    public MyGreasePayFragment() {
        // Required empty public constructor
        presenter = new BookingPresenterImpl(this, getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_grease_pay, container, false);
        bookingListRecycler = (RecyclerView) v.findViewById(R.id.fragment_my_greasepay_recycler);

        return v;
    }

    @Override
    public void onStart() {
        presenter.getBookingList();
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSuccess(Object objects) {
        bookingDatas = (ArrayList<BookingData>) objects;
        BookingListAdapter adapter = new BookingListAdapter(bookingDatas, new BookingListAdapter.OnRedeemClickListener() {
            @Override
            public void OnRedeemClick(int position) {
                BookingRedemptionRequest request = new BookingRedemptionRequest();
                request.setOrderId(bookingDatas.get(position).getOrderId());
                request.setRedemptionDate(bookingDatas.get(position).getRedemptionDate());
                request.setBouncerCode(bookingDatas.get(position).getPromoCode());
                request.setTotal(bookingDatas.get(position).getTotal());
                //todo Get stripe token
                request.setStripeToken(stripeToken);
                redemptionBooking(AppSharedPreference.getAuthToken(getActivity()), request);
            }
        });
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        bookingListRecycler.setLayoutManager(manager);
        bookingListRecycler.setAdapter(adapter);
    }

    @Override
    public Void onError(String message) {
        return null;
    }

    @Override
    public Void onServerError() {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    void redemptionBooking(String authToken, BookingRedemptionRequest bookingRedemptionRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> cal = retrofitInterface.bookingRedemption(authToken, bookingRedemptionRequest);
        cal.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                //todo redemption booking success function
                AlertManager.showErrorDialog(getActivity(), response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Override
    public void setTokenSendSuccessful(StripeResponse stripeResponse) {

    }

    @Override
    public void setTokenSendFail(String message) {

    }

    @Override
    public void getStripeTokenSuccessful(StripeTokenResponse stripeTokenResponse) {
        stripeToken = stripeTokenResponse.getStripeData().getStripeToken();
    }
}
