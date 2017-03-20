package com.ladse.greasepay.webclient_retro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ladse.greasepay.booking.AddRemoveFavoriteRequest;
import com.ladse.greasepay.booking.BookingRedemptionRequest;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.debitcard.model.DeleteCardRequest;
import com.ladse.greasepay.debitcard.model.DeleteCardResponse;
import com.ladse.greasepay.faq.FAQResponse;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.model.RestaurantResponse;
import com.ladse.greasepay.login.ForgotPasswordRequest;
import com.ladse.greasepay.profile.ProfileRequest;
import com.ladse.greasepay.sinup.model.SocialSinupRequest;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataFromServer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_delete_debit_card);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    void deleteDebitCard(String authToken,final DeleteCardRequest cardNumber){
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<DeleteCardResponse> cal = retrofitInterface.deleteDebitCard(authToken,cardNumber);
        cal.enqueue(new Callback<DeleteCardResponse>() {
            @Override
            public void onResponse(Call<DeleteCardResponse> call, Response<DeleteCardResponse> response) {
                AlertManager.showErrorDialog(GetDataFromServer.this,response.message());
            }

            @Override
            public void onFailure(Call<DeleteCardResponse> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    void redemptionBooking(String authToken,BookingRedemptionRequest bookingRedemptionRequest){
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> cal = retrofitInterface.bookingRedemption(authToken,bookingRedemptionRequest);
        cal.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(GetDataFromServer.this,response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getFavoriteData(String authToken, RestaurantRequest restaurantRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<RestaurantResponse> si = retrofitInterface.getFavorite(authToken, restaurantRequest);
        si.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                RestaurantResponse restaurantResponse = response.body();

            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void logOut(String authToken) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.logoutFromApp(authToken);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(GetDataFromServer.this,response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void forgotPassword(String authToken,ForgotPasswordRequest request) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.forgotPassword(authToken,request);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(GetDataFromServer.this,response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getFAQ() {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<FAQResponse> si = retrofitInterface.getFAQ();
        si.enqueue(new Callback<FAQResponse>() {
            @Override
            public void onResponse(Call<FAQResponse> call, Response<FAQResponse> response) {

            }

            @Override
            public void onFailure(Call<FAQResponse> call, Throwable t) {

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void addRemoveFavorite(String authToken, AddRemoveFavoriteRequest addRemoveFavoriteRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.addRemoveFavorite(authToken, addRemoveFavoriteRequest);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(GetDataFromServer.this,response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void editProfile(String authToken, ProfileRequest profileRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.editProfile(authToken,profileRequest);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void socialSinUp(String authToken, SocialSinupRequest socialSinupRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.socialSinup(socialSinupRequest);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }



}
